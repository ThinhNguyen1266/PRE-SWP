package swp.pre.swp.dto.response;

import lombok.Data;

@Data
public class BranchRespone {
    private Integer branch_id;
    private String branch_name;
    private String location;
    private String status;

    public BranchRespone(Integer branch_id, String branch_name, String location, String status) {
        this.branch_id = branch_id;
        this.branch_name = branch_name;
        this.location = location;
        this.status = status;
    }
}
