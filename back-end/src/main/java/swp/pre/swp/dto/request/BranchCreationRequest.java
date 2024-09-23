package swp.pre.swp.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults( level = AccessLevel.PRIVATE)
public class BranchCreationRequest {
    String Status;
    String  branch_name;
    String location;
}
