package swp.pre.swp.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "menu")

public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer menu_id;
    // Thiết lập khóa ngoại tới bảng Branch
    @ManyToOne
    @JoinColumn(name = "branch_id")
            BranchEntity branch; // Đây là trường liên kết với bảng Branch
}
