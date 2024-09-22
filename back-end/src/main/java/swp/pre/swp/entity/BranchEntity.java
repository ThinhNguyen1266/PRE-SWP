package swp.pre.swp.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "branch")
@EntityListeners(AuditingEntityListener.class)
public class BranchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generate the ID
     Integer branch_id;
     String Status;
     @CreatedDate
     @Temporal(TemporalType.TIMESTAMP)
     Timestamp create_date;

     @LastModifiedDate
     @Temporal(TemporalType.TIMESTAMP)
     Timestamp update_date;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    Timestamp delete_date;

     String  branch_name;
     String location;

}
