package swp.pre.swp.controller;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import swp.pre.swp.dto.request.RegisRequest;
import swp.pre.swp.dto.response.ApiResponse;
import swp.pre.swp.dto.response.CustomerResponse;
import swp.pre.swp.entity.CustomerEntity;
import swp.pre.swp.service.CustomerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerController {


    CustomerService customerService;

    @PostMapping("/users")
    public ApiResponse<List<CustomerResponse>> getCus() {
        return customerService.getCustomers();
    }


    @GetMapping("/{id}")
    public ApiResponse<CustomerResponse> getCusById(@PathVariable Integer id) {
        return customerService.getCustomer(id);
    }

    @PostMapping("/regis")
    public ApiResponse<CustomerResponse> regis(@RequestBody RegisRequest regisRequest) {
        return customerService.regis(regisRequest);
    }

}

