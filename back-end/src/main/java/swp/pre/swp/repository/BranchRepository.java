package swp.pre.swp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import swp.pre.swp.entity.BranchEntity;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<BranchEntity,Integer> {
    @Query("SELECT b FROM BranchEntity b WHERE b.Status = 'Active'")
    List<BranchEntity> findActiveBranches();
}
