package swp.pre.swp.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "food")
@Data
public class FoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int food_id;

    private String food_name;
    private String food_img;
    private String description;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "cat_id")
    private CategoryEntity categoryEntity;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createDate;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updateDate;


}
