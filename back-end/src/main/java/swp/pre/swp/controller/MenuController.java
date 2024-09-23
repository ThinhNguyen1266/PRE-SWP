package swp.pre.swp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import swp.pre.swp.dto.response.MenuResponse;
import swp.pre.swp.service.MenuService;

import java.util.List;

@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/branches/{branchId}/menu")
    public ResponseEntity<List<MenuResponse>> getMenuItems(@PathVariable Integer branchId) {
        List<MenuResponse> menuItems = menuService.getMenuItems(branchId);
        return ResponseEntity.ok(menuItems);
    }
}
