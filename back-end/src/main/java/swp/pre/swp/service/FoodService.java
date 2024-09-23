package swp.pre.swp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp.pre.swp.dto.request.BranchCreationRequest;
import swp.pre.swp.dto.request.FoodCreationRequest;
import swp.pre.swp.dto.request.FoodUpdateRequest;
import swp.pre.swp.entity.BranchEntity;
import swp.pre.swp.entity.CategoryEntity;
import swp.pre.swp.entity.FoodEntity;
import swp.pre.swp.mapper.BranchMapper;
import swp.pre.swp.mapper.FoodMapper;
import swp.pre.swp.repository.BranchRepository;
import swp.pre.swp.repository.CategoryRepository;
import swp.pre.swp.repository.FoodRepository;

import java.sql.Timestamp;

@Service



    public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private FoodMapper foodMapper;

    public FoodEntity createFood(FoodCreationRequest request) {
        // Find the category entity by cat_id
        CategoryEntity categoryEntity = categoryRepository.findById(request.getCat_id())
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + request.getCat_id()));

        // Create a new food entity
        FoodEntity foodEntity = new FoodEntity();
        foodEntity.setFood_name(request.getFood_name());
        foodEntity.setFood_img(request.getFood_img());
        foodEntity.setDescription(request.getDescription());
        foodEntity.setPrice(request.getPrice());
        foodEntity.setCategoryEntity(categoryEntity); // Set the retrieved category entity

        // Save the food entity to the database
        return foodRepository.save(foodEntity);
    }

    public FoodEntity updateFood(int food_id, FoodUpdateRequest request) {
        // Fetch the existing food entity by its ID
        FoodEntity foodEntity = foodRepository.findById(food_id)
                .orElseThrow(() -> new RuntimeException("Food not found with ID: " + food_id));

        // Check if a new category needs to be updated
        if (request.getCat_id() != null) {
            CategoryEntity categoryEntity = categoryRepository.findById(request.getCat_id())
                    .orElseThrow(() -> new RuntimeException("Category not found with ID: " + request.getCat_id()));
            foodEntity.setCategoryEntity(categoryEntity);
        }
        foodMapper.updateFood(foodEntity, request);
        // Update the updateDate timestamp
        foodEntity.setUpdateDate(new Timestamp(System.currentTimeMillis()));
        // Save the updated entity
        return foodRepository.save(foodEntity);
    }
}
