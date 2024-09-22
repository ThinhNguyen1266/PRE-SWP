package swp.pre.swp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swp.pre.swp.entity.MenuEntity;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity,Integer> {
}
