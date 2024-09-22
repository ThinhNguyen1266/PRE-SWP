package swp.pre.swp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp.pre.swp.entity.BranchEntity;
import swp.pre.swp.repository.BranchRepository;

import java.util.List;

@Service
public class BranchService {
    @Autowired
    private BranchRepository branchRepository;

    public List<BranchEntity> getAllBranches() {
        return branchRepository.findAll();
    }
}
