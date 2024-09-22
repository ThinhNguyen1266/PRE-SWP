package swp.pre.swp.config;



import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import swp.pre.swp.entity.CustomerEntity;
import swp.pre.swp.repository.CustomerRepository;

@Configuration
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApplicationConfiguration {

    PasswordEncoder passwordEncoder;

    @NonFinal
    static final String ADMIN_USER_NAME = "admin";

    @NonFinal
    static final String ADMIN_PASSWORD = "admin";

//    @Bean
//    ApplicationRunner applicationRunner(CustomerRepository customerRepository) {
//        return args -> {
//            if (customerRepository.findByUsername(ADMIN_USER_NAME).isEmpty()) {
//                CustomerEntity cusAccount = CustomerEntity.builder()
//                        .username(ADMIN_USER_NAME)
//                        .password(passwordEncoder.encode(ADMIN_PASSWORD))
//                        .email("admin@example.com")
//                        .role("ADMIN")
//                        .build();
//                customerRepository.save(cusAccount);
//                log.warn("admin user has been created with default password: admin, please change it");
//            }
//        };
//    }


}
