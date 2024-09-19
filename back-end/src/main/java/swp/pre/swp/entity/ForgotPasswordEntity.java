package swp.pre.swp.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@Table(name = "forgot_password")
public class ForgotPasswordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer fpid;
    @Column(nullable = false)
    Integer otp;
    @Column(nullable = false)
    Date expirationTime;
    @OneToOne
    CustomerEntity customer;
    Integer ok;
}
