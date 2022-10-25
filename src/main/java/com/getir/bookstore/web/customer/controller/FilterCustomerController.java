package com.getir.bookstore.web.customer.controller;

import com.getir.bookstore.common.pageable.request.Pageable;
import com.getir.bookstore.common.response.ApplicationResponse;
import com.getir.bookstore.common.utils.PagingUtils;
import com.getir.bookstore.core.customer.model.domain.Customer;
import com.getir.bookstore.core.customer.model.dto.FilterCustomerDTO;
import com.getir.bookstore.core.customer.service.CustomerService;
import com.getir.bookstore.web.customer.mapper.FilterCustomerRequestMapper;
import com.getir.bookstore.web.customer.mapper.FilterCustomerResponseMapper;
import com.getir.bookstore.web.customer.request.FilterCustomerRequest;
import com.getir.bookstore.web.customer.response.FilterCustomerResponse;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/customers")
@Validated
public class FilterCustomerController {

    private final CustomerService customerService;
    private final FilterCustomerRequestMapper filterCustomerRequestMapper;
    private final FilterCustomerResponseMapper filterCustomerResponseMapper;

    public FilterCustomerController(CustomerService customerService, FilterCustomerRequestMapper filterCustomerRequestMapper, FilterCustomerResponseMapper filterCustomerResponseMapper) {
        this.customerService = customerService;
        this.filterCustomerRequestMapper = filterCustomerRequestMapper;
        this.filterCustomerResponseMapper = filterCustomerResponseMapper;
    }


    @PostMapping("/filter")
    public ApplicationResponse filterCustomers(@Valid @RequestBody Pageable<FilterCustomerRequest> filterCustomerRequestPageable) {

        Pageable<FilterCustomerDTO> filterCustomerDTOPagable = filterCustomerRequestMapper.toDTO(filterCustomerRequestPageable);

        Page<Customer> pageCustomer = customerService.filterPaging(filterCustomerDTOPagable);

        List<FilterCustomerResponse> filterCustomerResponses = filterCustomerResponseMapper.toListResponse(pageCustomer.getContent());

        return ApplicationResponse.builder()
                .success(true)
                .content(PagingUtils.getPageableResponse(filterCustomerResponses, pageCustomer))
                .build();
    }

}
