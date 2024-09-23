package swp.pre.swp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "category")
@Data
public class CategoryEntity {
    @Column(name = "cat_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cat_id;

    private String cat_name;

}
