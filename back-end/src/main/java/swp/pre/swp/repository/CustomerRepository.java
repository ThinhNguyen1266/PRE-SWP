package swp.pre.swp.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import swp.pre.swp.entity.CustomerEntity;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer> {

    Optional<CustomerEntity> findByUsername  (String username);
    Optional<CustomerEntity> findByEmail  (String email);

    @Transactional
    @Modifying
    @Query("update CustomerEntity c set c.password = ?2 where c.email =?1")
    void updatePassword(String email, String password);

}
