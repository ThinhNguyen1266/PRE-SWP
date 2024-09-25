package swp.pre.swp.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Table(name = "employee_account")
@EntityListeners(AuditingEntityListener.class)
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer emp_id;

    String status;
    String role;
    String emp_username;
    String enp_fullname;
    String emp_password;
    String emp_phonenumber;
    String emp_email;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    Timestamp create_date;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    Timestamp update_date;


    @Column(name = "branch_id")  // Foreign key placeholder
    Integer branch_id;

}
