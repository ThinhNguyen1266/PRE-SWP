package swp.pre.swp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import swp.pre.swp.dto.request.BranchCreationRequest;
import swp.pre.swp.dto.request.BranchUpdateRequest;
import swp.pre.swp.entity.BranchEntity;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BranchMapper {
    BranchEntity toBranch(BranchCreationRequest request);
    void updateBranch(@MappingTarget BranchEntity branchEntity, BranchUpdateRequest request);
}
