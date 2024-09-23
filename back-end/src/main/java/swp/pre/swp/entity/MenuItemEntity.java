package swp.pre.swp.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "menu_item")
@Data
public class MenuItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private MenuEntity menuEntity;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private FoodEntity foodEntity;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private BranchEntity branchEntity;

    private String status;
    
}
