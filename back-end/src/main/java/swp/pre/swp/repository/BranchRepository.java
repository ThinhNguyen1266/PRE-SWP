package swp.pre.swp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swp.pre.swp.entity.BranchEntity;

@Repository
public interface BranchRepository extends JpaRepository<BranchEntity,Integer> {
}
