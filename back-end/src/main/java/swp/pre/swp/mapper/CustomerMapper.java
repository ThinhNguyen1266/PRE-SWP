package swp.pre.swp.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import swp.pre.swp.entity.CustomerEntity;

public interface CustomerMapper extends JpaRepository<CustomerEntity,Integer> {

}
