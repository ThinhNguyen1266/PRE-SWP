package swp.pre.swp.entity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "cus_account")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generate the ID
     Integer id;
     String username;
     String full_name;
     String password;
     String email;
     Integer vip_point;
     String status;
     Timestamp create_date;
     Timestamp update_date;

     @OneToOne(mappedBy = "customer" )
     private ForgotPasswordEntity forgotPassword;
}
