package swp.pre.swp.service;

import swp.pre.swp.dto.request.RegisRequest;
import swp.pre.swp.dto.response.ApiResponse;
import swp.pre.swp.dto.response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    public ApiResponse<List<CustomerResponse>> getCustomers();

    public ApiResponse<CustomerResponse> getCustomer(Integer customerId);


    public ApiResponse<CustomerResponse> regis(RegisRequest regisRequest);
}
