package swp.pre.swp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp.pre.swp.dto.request.EmployeeCreationRequest;
import swp.pre.swp.dto.request.EmployeeUpdateRequest;
import swp.pre.swp.entity.EmployeeEntity;
import swp.pre.swp.mapper.EmployeeMapper;
import swp.pre.swp.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;
    public EmployeeEntity createEmployee(EmployeeCreationRequest request){
        EmployeeEntity employee = employeeMapper.toEmployee(request);
         employee  = employeeRepository.save(employee);
         return employee;

    }

    public EmployeeEntity updateEmployee(Integer employeeID,EmployeeUpdateRequest request){

         EmployeeEntity employeeEntity = employeeRepository.findById(employeeID).orElseThrow(() -> new RuntimeException("Food not found with ID: " + employeeID));
       employeeMapper.updateEmployee(employeeEntity,request);
        return employeeRepository.save(employeeEntity);
    }

    public EmployeeEntity deleteEmployee(Integer employeeID) {
        // Find the branch by its ID
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeID)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + employeeID));

        // Change status to 'Inactive'
        employeeEntity.setStatus("Inactive");

        // Update the delete_date timestamp (if needed)


        // Save the updated branch
        return employeeRepository.save(employeeEntity);


    }

    public List<EmployeeEntity> getEmployee(){
        return employeeRepository.findAll();
    }

}
