package swp.pre.swp.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import swp.pre.swp.entity.CustomerEntity;
import swp.pre.swp.entity.ForgotPasswordEntity;

import java.util.Date;
import java.util.Optional;

@Repository
public interface ForgotPasswordRepository extends JpaRepository<ForgotPasswordEntity,Integer> {
    @Query("select fp from ForgotPasswordEntity fp where fp.otp = ?1 and fp.customer = ?2")
    Optional<ForgotPasswordEntity> findByOtpAndUser(Integer otp, CustomerEntity customer);


    @Transactional
    @Modifying
    @Query("update ForgotPasswordEntity c set c.ok = ?1 where c.otp =?2")
    void updatePassword(Integer ok, Integer otp);



    void deleteAllByExpirationTimeBefore(Date now);

    @Query("select fp from ForgotPasswordEntity fp  where fp.customer = ?1")
    Optional<ForgotPasswordEntity> get(CustomerEntity customer);



}
