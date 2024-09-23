package swp.pre.swp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swp.pre.swp.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {
}
