package swp.pre.swp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import swp.pre.swp.dto.request.EmployeeCreationRequest;
import swp.pre.swp.dto.request.EmployeeUpdateRequest;
import swp.pre.swp.dto.response.EmployeeResponse;
import swp.pre.swp.entity.EmployeeEntity;
import swp.pre.swp.mapper.EmployeeMapper;
import swp.pre.swp.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeMapper employeeMapper;
    @PostMapping("/create")
    EmployeeEntity createUser(@RequestBody EmployeeCreationRequest request){
        
        return employeeService.createEmployee(request);
    }

    @PutMapping("/update/{userId}")
    EmployeeEntity updateUser(@PathVariable Integer userId, @RequestBody EmployeeUpdateRequest request){

        return employeeService.updateEmployee(userId, request);
    }

    @GetMapping("/getall")
    List<EmployeeEntity> getUsers(){
        return employeeService.getEmployee();
    }

    @PutMapping("/delete/{userId}")
    EmployeeResponse deleteBranch(@PathVariable("userId") Integer user_id) {
        EmployeeEntity employeeEntity= employeeService.deleteEmployee(user_id);
        // Return a response object
        return new EmployeeResponse(user_id,employeeEntity.getStatus(),employeeEntity.getRole()
                                    ,employeeEntity.getEmp_username(), employeeEntity.getEnp_fullname(),
                employeeEntity.getEmp_password(), employeeEntity.getEmp_phonenumber(), employeeEntity.getEmp_email(), employeeEntity.getBranch_id()
        );
    }



}

