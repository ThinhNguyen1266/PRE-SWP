package swp.pre.swp.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import swp.pre.swp.repository.ForgotPasswordRepository;


import java.time.Instant;
import java.util.Date;

@Service
public class SchedulesService {

    @Autowired
    ForgotPasswordRepository forgotPasswordRepository;

    @Transactional
    @Scheduled(fixedRate = 10000)
    public void delete(){
        Date now = Date.from(Instant.now());
        forgotPasswordRepository.deleteAllByExpirationTimeBefore(now);
    }

}
