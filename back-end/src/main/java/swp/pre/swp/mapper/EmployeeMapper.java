package swp.pre.swp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import swp.pre.swp.dto.request.EmployeeCreationRequest;
import swp.pre.swp.dto.request.EmployeeUpdateRequest;
import swp.pre.swp.entity.EmployeeEntity;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EmployeeMapper {
    EmployeeEntity toEmployee(EmployeeCreationRequest request);
    void updateEmployee(@MappingTarget EmployeeEntity employeeEntity, EmployeeUpdateRequest request);

}
