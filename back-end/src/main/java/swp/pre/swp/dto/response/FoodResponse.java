package swp.pre.swp.dto.response;

import jakarta.persistence.JoinColumn;
import lombok.Data;
import swp.pre.swp.entity.CategoryEntity;

import java.math.BigDecimal;

@Data
public class FoodResponse {
    private int food_id;
    private String food_name;
    private String food_img;
    private String description;
    private BigDecimal price;
    private CategoryEntity categoryEntity; // Only pass the category ID

    public FoodResponse(int food_id, String food_name, String food_img, String description, BigDecimal price, CategoryEntity categoryEntity) {
        this.food_id = food_id;
        this.food_name = food_name;
        this.food_img = food_img;
        this.description = description;
        this.price = price;
        this.categoryEntity = categoryEntity;
    }
}
