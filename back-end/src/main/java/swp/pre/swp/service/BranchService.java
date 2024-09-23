package swp.pre.swp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp.pre.swp.dto.request.BranchCreationRequest;
import swp.pre.swp.dto.request.BranchUpdateRequest;
import swp.pre.swp.dto.response.BranchResponse;
import swp.pre.swp.entity.BranchEntity;
import swp.pre.swp.mapper.BranchMapper;
import swp.pre.swp.repository.BranchRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchService {
    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private BranchMapper branchMapper;
    public List<BranchResponse> getAllActiveBranches() {
        List<BranchEntity> branches = branchRepository.findActiveBranches();
        return branches.stream()
                .map(b -> new BranchResponse(b.getBranch_id(), b.getBranch_name(), b.getLocation()))
                .collect(Collectors.toList());
    }
    public BranchEntity createBranch(BranchCreationRequest request){
        BranchEntity branchEntity = branchMapper.toBranch(request);
        return branchRepository.save(branchEntity);
    }
    public BranchEntity getBranchByID(Integer branch_id){
        return branchRepository.findById(branch_id).orElseThrow(() -> new RuntimeException("Branch not found"));
    }
    public  BranchEntity updateBranch(Integer branch_id, BranchUpdateRequest request){
        BranchEntity branchEntity = getBranchByID(branch_id);
        branchMapper.updateBranch(branchEntity,request);
        return branchRepository.save(branchEntity);
    }
    public BranchEntity deleteBranch(Integer branch_id) {
        // Find the branch by its ID
        BranchEntity branchEntity = branchRepository.findById(branch_id)
                .orElseThrow(() -> new RuntimeException("Branch not found with ID: " + branch_id));

        // Change status to 'Inactive'
        branchEntity.setStatus("Inactive");

        // Update the delete_date timestamp (if needed)
        branchEntity.setDelete_date(new Timestamp(System.currentTimeMillis()));

        // Save the updated branch
         return branchRepository.save(branchEntity);


    }



}
