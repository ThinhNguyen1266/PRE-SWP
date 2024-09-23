package swp.pre.swp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import swp.pre.swp.dto.request.BranchCreationRequest;
import swp.pre.swp.dto.request.FoodCreationRequest;
import swp.pre.swp.dto.request.FoodUpdateRequest;
import swp.pre.swp.dto.response.BranchResponse;
import swp.pre.swp.dto.response.FoodResponse;
import swp.pre.swp.entity.BranchEntity;
import swp.pre.swp.entity.FoodEntity;
import swp.pre.swp.service.BranchService;
import swp.pre.swp.service.FoodService;

@RestController
public class FoodController {
    @Autowired
    private FoodService foodService;
    @PostMapping("/create/food")

    public FoodResponse createFood(@RequestBody FoodCreationRequest request) {
        FoodEntity foodEntity = foodService.createFood(request);
        return new FoodResponse(
                foodEntity.getFood_id(),
                foodEntity.getFood_name(),
                foodEntity.getFood_img(),
                foodEntity.getDescription(),
                foodEntity.getPrice(),
                foodEntity.getCategoryEntity().getCat_id()
        );
    }
    @PutMapping("/food/{food_id}/update")
    public FoodResponse updateFood(@PathVariable("food_id") int food_id, @RequestBody FoodUpdateRequest request) {
        FoodEntity foodEntity =  foodService.updateFood(food_id, request);
        return new FoodResponse(
                foodEntity.getFood_id(),
                foodEntity.getFood_name(),
                foodEntity.getFood_img(),
                foodEntity.getDescription(),
                foodEntity.getPrice(),
                foodEntity.getCategoryEntity().getCat_id()
        );
    }


}
