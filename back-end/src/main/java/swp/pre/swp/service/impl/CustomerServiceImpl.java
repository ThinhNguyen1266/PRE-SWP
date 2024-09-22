package swp.pre.swp.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import swp.pre.swp.dto.request.RegisRequest;
import swp.pre.swp.dto.response.ApiResponse;
import swp.pre.swp.dto.response.CustomerResponse;
import swp.pre.swp.entity.CustomerEntity;
import swp.pre.swp.mapper.CustomerMapper;
import swp.pre.swp.repository.CustomerRepository;
import swp.pre.swp.service.CustomerService;

import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;
    CustomerMapper customerMapper;

    @Override
    public ApiResponse<List<CustomerResponse>> getCustomers() {
        return ApiResponse.<List<CustomerResponse>>builder()
                .message("success")
                .data(customerRepository.findAll().stream().map(customerMapper::toCusResponse).toList())
                .build();
    }

    @Override
    public ApiResponse<CustomerResponse> getCustomer(Integer customerId) {
        return ApiResponse.<CustomerResponse>builder()
                .message("success")
                .data(customerMapper.toCusResponse(customerRepository.findById(customerId).get()))
                .build();
    }

    @Override
    public ApiResponse<CustomerResponse> regis(RegisRequest regisRequest) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        CustomerEntity customer = customerMapper.regisRequestToCusAccount(regisRequest);
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerRepository.save(customer);
        return  ApiResponse.<CustomerResponse>builder()
                .message("success")
                .data(customerMapper.toCusResponse(customer))
                .build();
    }
}
