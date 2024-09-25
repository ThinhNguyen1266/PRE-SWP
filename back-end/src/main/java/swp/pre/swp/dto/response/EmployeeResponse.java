package swp.pre.swp.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeResponse {
    Integer emp_id;
    String status;
    String role;
    String emp_username;
    String enp_fullname;
    String emp_password;
    String emp_phonenumber;
    String emp_email;
    Integer branch_id;

    public EmployeeResponse(Integer emp_id, String status, String role, String emp_username, String enp_fullname, String emp_password, String emp_phonenumber, String emp_email, Integer branch_id) {
        this.emp_id = emp_id;
        this.status = status;
        this.role = role;
        this.emp_username = emp_username;
        this.enp_fullname = enp_fullname;
        this.emp_password = emp_password;
        this.emp_phonenumber = emp_phonenumber;
        this.emp_email = emp_email;
        this.branch_id = branch_id;
    }
}
