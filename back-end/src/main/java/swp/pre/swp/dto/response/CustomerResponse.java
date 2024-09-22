package swp.pre.swp.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    Integer id;
    String username;
    String full_name;
    String password;
    String email;
    Integer vip_point;
    String status;
    Timestamp create_date;
    Timestamp update_date;
}
