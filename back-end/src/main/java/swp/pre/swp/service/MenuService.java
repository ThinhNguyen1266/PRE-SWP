package swp.pre.swp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp.pre.swp.dto.response.MenuResponse;
import swp.pre.swp.entity.FoodEntity;
import swp.pre.swp.entity.MenuItemEntity;
import swp.pre.swp.repository.MenuItemRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {

    @Autowired
    private MenuItemRepository menuItemRepository; // Inject your repository

    public List<MenuResponse> getMenuItems(Integer branchId) {
        List<MenuItemEntity> menuItemEntities = menuItemRepository.findByBranchId(branchId); // Fetch MenuItemEntities
        return menuItemEntities.stream().map(menuItem ->
                new MenuResponse(
                        menuItem.getFoodEntity().getFood_id(), // Assuming MenuItemEntity has a reference to FoodEntity
                        menuItem.getFoodEntity().getFood_name(),
                        menuItem.getFoodEntity().getFood_img(),
                        menuItem.getFoodEntity().getPrice(),
                        menuItem.getFoodEntity().getDescription(),
                        menuItem.getFoodEntity().getCategoryEntity().getCat_id() // Assuming category is an entity
                )
        ).collect(Collectors.toList());
    }
}
