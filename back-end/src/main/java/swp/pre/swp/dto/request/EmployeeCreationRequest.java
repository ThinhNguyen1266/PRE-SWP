package swp.pre.swp.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeCreationRequest {
    String status;
    String role;
    String emp_username;
    String enp_fullname;
    String emp_password;
    String emp_phonenumber;
    String emp_email;
    String branch_id;
}
