package swp.pre.swp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import swp.pre.swp.dto.MailBody;
import swp.pre.swp.entity.CustomerEntity;
import swp.pre.swp.entity.ForgotPasswordEntity;

import swp.pre.swp.repository.CustomerRepository;
import swp.pre.swp.repository.ForgotPasswordRepository;
import swp.pre.swp.service.MailService;
import swp.pre.swp.utils.ChangePassword;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

@RestController
@RequestMapping("/forgotPassword")
public class ForgotPasswordController {
        private final CustomerRepository customerRepository;

        private final MailService mailService;

        private final ForgotPasswordRepository forgotPasswordRepository;

        private final PasswordEncoder passwordEncoder;

    public ForgotPasswordController(CustomerRepository customerRepository, MailService mailService, ForgotPasswordRepository forgotPasswordRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.mailService = mailService;
        this.forgotPasswordRepository = forgotPasswordRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //send mail for email verification
    @PostMapping("/verifyMail/{email}")
    public ResponseEntity<String> verifyEmail(@PathVariable String email ){
        CustomerEntity customerEntity = customerRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("Please provide a valid email!"));
        int otp = OtpGenerator();
        MailBody mailBody = MailBody.builder()
                .to(email)
                .text("This is the OTP for your Forgot Password request : "+ otp)
                .subject("OTP for Forgot Password request")
                .build();

        ForgotPasswordEntity fp = ForgotPasswordEntity.builder()
                .otp(otp)
                .expirationTime(new Date(System.currentTimeMillis()+12000))
                .customer(customerEntity)
                .ok(0)
                .build();

        mailService.sendSimpleMessage(mailBody);
        forgotPasswordRepository.save(fp);

        return ResponseEntity.ok("Email has been verifycation");
    }
    // API xác thực OTP
    @PostMapping("/verifyOtp/{otp}/{email}")
    public ResponseEntity<String> verifyOtp(@PathVariable Integer otp, @PathVariable String email){
        CustomerEntity customerEntity = customerRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("Please provide a valid email!"));
        ForgotPasswordEntity fp = forgotPasswordRepository.findByOtpAndUser(otp,customerEntity)
                .orElseThrow(()-> new RuntimeException("Invalid Otp for email "+ email));

        //Kiểm tra Otp có hết hạn không
        if(fp.getExpirationTime().before(Date.from(Instant.now()))) {
            return new ResponseEntity<>("OTP has expired!", HttpStatus.EXPECTATION_FAILED);
        }else{
            forgotPasswordRepository.updatePassword(1,otp);
        }

        return ResponseEntity.ok("OTP verified!");
    }

    //API đổi mật khẩu
    @PostMapping("/changePassword/{email}")
    public ResponseEntity<String> changePasswordHandler(@RequestBody ChangePassword changePassword, @PathVariable String email){

        // kiểm tra mật khẩu mới có giống phần nhập lại mật khẩu không
        CustomerEntity cus = customerRepository.findByEmail(email).orElseThrow(()->new RuntimeException("ko co eamil"));
        ForgotPasswordEntity forgotPassword = forgotPasswordRepository.get(cus).orElseThrow(()->new RuntimeException("ko co eamil"));


        if(!Objects.equals(changePassword.password(),changePassword.repeatPassword())){
            return new ResponseEntity<>("Please enter a password again!",HttpStatus.EXPECTATION_FAILED);
        }
        if(forgotPassword.getOk()==1){
            // Mã hóa lại mật khẩu mới của người dùng
            String encodedPassword = passwordEncoder.encode(changePassword.password());
            customerRepository.updatePassword(email,encodedPassword);
            return ResponseEntity.ok("Password has been changed!");
        }
        return new ResponseEntity<>("Please enter OTP first!",HttpStatus.EXPECTATION_FAILED);


    }

    private Integer OtpGenerator(){
        Random random = new Random();
        return random.nextInt(100_000,999_999);
    }
}
