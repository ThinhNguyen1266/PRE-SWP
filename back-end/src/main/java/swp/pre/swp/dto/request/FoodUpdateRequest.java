package swp.pre.swp.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FoodUpdateRequest {
     String food_name;
     String food_img;
     String description;
     BigDecimal price;
     Integer cat_id; // New category ID for update, if applicable
}
