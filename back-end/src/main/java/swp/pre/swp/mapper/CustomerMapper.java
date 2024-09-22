package swp.pre.swp.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import swp.pre.swp.dto.request.RegisRequest;
import swp.pre.swp.dto.response.CustomerResponse;
import swp.pre.swp.entity.CustomerEntity;


@Mapper(componentModel = "spring")
public interface CustomerMapper  {
    CustomerEntity cusResponseToCusAccount(CustomerResponse cusResponse);

    CustomerEntity regisRequestToCusAccount(RegisRequest regisRequest);

    CustomerResponse toCusResponse(CustomerEntity account);
}
