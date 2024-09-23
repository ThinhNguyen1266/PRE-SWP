package swp.pre.swp.dto.response;

import lombok.Data;

@Data
public class BranchResponse {
    private Integer branch_id;
    private String branch_name;
    private String location;


    public BranchResponse(Integer branch_id, String branch_name, String location) {
        this.branch_id = branch_id;
        this.branch_name = branch_name;
        this.location = location;

    }
}
