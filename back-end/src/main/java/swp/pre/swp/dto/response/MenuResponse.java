package swp.pre.swp.dto.response;

import lombok.Data;
import swp.pre.swp.entity.CategoryEntity;

import java.math.BigDecimal;
@Data
public class MenuResponse {
    private int food_id;
    private String food_name;
    private String food_img;
    private BigDecimal price;
    private String description;
    private CategoryEntity categoryEntity;

    public MenuResponse(int food_id, String food_name, String food_img, BigDecimal price, String description, CategoryEntity categoryEntity) {
        this.food_id = food_id;
        this.food_name = food_name;
        this.food_img = food_img;
        this.price = price;
        this.description = description;
        this.categoryEntity = categoryEntity;
    }
}
