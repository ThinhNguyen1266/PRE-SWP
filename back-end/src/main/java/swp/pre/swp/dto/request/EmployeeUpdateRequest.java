package swp.pre.swp.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeUpdateRequest {
    String status;
    String role;
    String enp_fullname;
    String emp_password;
    String emp_phonenumber;
    String emp_email;
    Timestamp update_date;
    String branch_id;
}
