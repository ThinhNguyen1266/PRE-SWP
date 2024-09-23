package swp.pre.swp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import swp.pre.swp.dto.request.BranchCreationRequest;
import swp.pre.swp.dto.request.BranchUpdateRequest;
import swp.pre.swp.dto.response.BranchResponse;
import swp.pre.swp.entity.BranchEntity;
import swp.pre.swp.service.BranchService;

import java.util.List;

@RestController
public class BranchController {
    @Autowired
    private BranchService branchService;

    @GetMapping("/branches")
    public List<BranchResponse> getAllActiveBranches() {
        return branchService.getAllActiveBranches(); // Trả về danh sách chi nhánh active
    }
    @PostMapping("/create/branches")
    BranchResponse createBranch(@RequestBody BranchCreationRequest request) {
        BranchEntity branchEntity = branchService.createBranch(request);
        return new BranchResponse(
                branchEntity.getBranch_id(),
                branchEntity.getBranch_name(),
                branchEntity.getLocation()
        );
    }
    @GetMapping("/branches/{branch_id}/getbyid")
    BranchResponse getBranchByID(@PathVariable("branch_id") Integer branch_id){
        BranchEntity branchEntity= branchService.getBranchByID(branch_id);
        return new BranchResponse(
                branchEntity.getBranch_id(),
                branchEntity.getBranch_name(),
                branchEntity.getLocation()
        );
    }
    @PutMapping("/branches/{branch_id}/update")
    BranchResponse updateBrand(@PathVariable("branch_id") Integer branch_id,@RequestBody BranchUpdateRequest request){
        BranchEntity branchEntity= branchService.updateBranch(branch_id,request);
        return new BranchResponse(
                branchEntity.getBranch_id(),
                branchEntity.getBranch_name(),
                branchEntity.getLocation()
        );
    }
    @PutMapping("/branches/{branch_id}/delete")
     BranchResponse deleteBranch(@PathVariable("branch_id") Integer branch_id) {
        BranchEntity branchEntity= branchService.deleteBranch(branch_id);
        // Return a response object
        return new BranchResponse(
                branchEntity.getBranch_id(),
                branchEntity.getBranch_name(),
                branchEntity.getLocation()
        );
    }



}
