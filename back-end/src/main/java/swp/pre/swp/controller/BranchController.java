package swp.pre.swp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import swp.pre.swp.entity.BranchEntity;
import swp.pre.swp.service.BranchService;

import java.util.List;

@RestController
public class BranchController {
    @Autowired
    private BranchService branchService;

    @GetMapping("/branches")
    public List<BranchEntity> getAllBranches() {
        return branchService.getAllBranches(); // Trả về danh sách chi nhánh và menu của mỗi chi nhánh
    }
}
