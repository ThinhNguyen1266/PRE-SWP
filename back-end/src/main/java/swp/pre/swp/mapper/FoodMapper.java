package swp.pre.swp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import swp.pre.swp.dto.request.BranchCreationRequest;
import swp.pre.swp.dto.request.BranchUpdateRequest;
import swp.pre.swp.dto.request.FoodCreationRequest;
import swp.pre.swp.dto.request.FoodUpdateRequest;
import swp.pre.swp.entity.BranchEntity;
import swp.pre.swp.entity.FoodEntity;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FoodMapper {
    void updateFood(@MappingTarget FoodEntity foodEntity, FoodUpdateRequest request);
}
