package swp.pre.swp.dto.request;

import jakarta.persistence.JoinColumn;
import lombok.*;
import lombok.experimental.FieldDefaults;
import swp.pre.swp.entity.CategoryEntity;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults( level = AccessLevel.PRIVATE)
public class FoodCreationRequest {
    Integer cat_id; // Only pass the category ID
    String food_name;
    String food_img;
    String description;
    BigDecimal price;
}
