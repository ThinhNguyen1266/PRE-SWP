package swp.pre.swp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swp.pre.swp.entity.FoodEntity;

public interface FoodRepository extends JpaRepository<FoodEntity,Integer> {
}
