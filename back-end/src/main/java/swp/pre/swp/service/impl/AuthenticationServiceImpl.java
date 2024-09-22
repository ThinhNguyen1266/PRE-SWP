package swp.pre.swp.service.impl;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import swp.pre.swp.dto.request.AuthenticationRequest;
import swp.pre.swp.dto.request.IntrospectRequest;
import swp.pre.swp.dto.response.ApiResponse;
import swp.pre.swp.dto.response.AuthenticationResponse;
import swp.pre.swp.dto.response.CustomerResponse;
import swp.pre.swp.dto.response.IntrospectResponse;
import swp.pre.swp.entity.CustomerEntity;
import swp.pre.swp.exception.AppException;
import swp.pre.swp.exception.ErrorCode;
import swp.pre.swp.repository.CustomerRepository;
import swp.pre.swp.service.AuthenticationService;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.StringJoiner;
@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationServiceImpl implements AuthenticationService {

    CustomerRepository customerRepository;

    @NonFinal
    @Value("${jwt.signerKey}")
    String SIGNER_KEY;

    @NonFinal
    @Value("${jwt.validDuration}")
    long VALID_DURATION;

    @Override
    public ApiResponse<IntrospectResponse> introspect(IntrospectRequest introspectRequest) {
        String token = introspectRequest.getToken();
        boolean isValid = true;
        try {
            verifyToken(token);
        } catch (Exception e) {
            isValid = false;
        }
        return ApiResponse.<IntrospectResponse>builder()
                .data(IntrospectResponse.builder()
                        .valid(isValid)
                        .build())
                .build();
    }

    @Override
    public ApiResponse<AuthenticationResponse> authenticate(AuthenticationRequest authenticationRequest) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        CustomerEntity account = customerRepository
                .findByUsername(authenticationRequest.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        boolean authenticated = passwordEncoder.matches(authenticationRequest.getPassword(), account.getPassword());
        return ApiResponse.<AuthenticationResponse>builder()
                .data(AuthenticationResponse.builder()
                        .token(authenticated ? (generateToken(account)) : null)
                        .authenticated(authenticated)
                        .build())
                .build();
    }

    private String generateToken(CustomerEntity account) {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .issuer("demo.example")
                .subject(account.getUsername())
                .issueTime(new Date())
//                .claim("scope", buildScope(account))
                .expirationTime(
                        new Date(Instant.now().plus(VALID_DURATION, ChronoUnit.SECONDS).toEpochMilli()))
                .build();

        Payload payload = new Payload(claimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);
        try {
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            log.error(e.getMessage());
            throw new AppException(ErrorCode.UNAUTHENTICATED);
        }
    }

    private SignedJWT verifyToken(String token) throws JOSEException, ParseException {
        JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());
        SignedJWT signedJWT = SignedJWT.parse(token);
        Date expireTime = signedJWT.getJWTClaimsSet().getExpirationTime();
        boolean verified = signedJWT.verify(verifier);
        if (!(verified && expireTime.after(new Date()))) throw new JOSEException("token expired");
        return signedJWT;
    }

//    private String buildScope(CusAccount account) {
//        StringJoiner stringJoiner = new StringJoiner(" ");
//        if (!account.getRole().isEmpty()) {
//            stringJoiner.add("ROLE_" + account.getRole());
//        }
//        return stringJoiner.toString();
//    }


}
