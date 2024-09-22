package swp.pre.swp.service;


import org.springframework.stereotype.Service;
import swp.pre.swp.dto.request.AuthenticationRequest;
import swp.pre.swp.dto.request.IntrospectRequest;
import swp.pre.swp.dto.response.ApiResponse;
import swp.pre.swp.dto.response.AuthenticationResponse;
import swp.pre.swp.dto.response.IntrospectResponse;

@Service
public interface AuthenticationService {
    public ApiResponse<AuthenticationResponse> authenticate(AuthenticationRequest authenticationRequest);

    public ApiResponse<IntrospectResponse> introspect(IntrospectRequest introspectRequest);
}
