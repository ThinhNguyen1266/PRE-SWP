package swp.pre.swp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import swp.pre.swp.entity.MenuItemEntity;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItemEntity, Integer> {
    @Query("SELECT m FROM MenuItemEntity m WHERE m.branchEntity.branch_id = ?1")
    List<MenuItemEntity> findByBranchId(int branchId);
}
