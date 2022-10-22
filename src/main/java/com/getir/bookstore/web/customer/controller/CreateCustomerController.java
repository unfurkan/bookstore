package com.getir.bookstore.web.customer.controller;

import com.getir.bookstore.common.response.ApplicationResponse;
import com.getir.bookstore.core.customer.model.domain.Customer;
import com.getir.bookstore.core.customer.model.dto.CreateCustomerDTO;
import com.getir.bookstore.core.customer.usecase.CreateCustomerUseCase;
import com.getir.bookstore.web.customer.mapper.CreateCustomerRequestMapper;
import com.getir.bookstore.web.customer.mapper.CreateCustomerResponseMapper;
import com.getir.bookstore.web.customer.request.CreateCustomerRequest;
import com.getir.bookstore.web.customer.response.CreateCustomerResponse;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/v1/customers")
@RestController
public class CreateCustomerController {

    private final CreateCustomerRequestMapper createCustomerRequestMapper;
    private final CreateCustomerUseCase createCustomerUseCase;
    private final CreateCustomerResponseMapper createCustomResponseMapper;

    public CreateCustomerController(MessageSource messageSource, CreateCustomerRequestMapper createCustomerRequestMapper, CreateCustomerUseCase createCustomerUseCase, CreateCustomerResponseMapper createCustomResponseMapper) {
        this.createCustomerRequestMapper = createCustomerRequestMapper;
        this.createCustomerUseCase = createCustomerUseCase;
        this.createCustomResponseMapper = createCustomResponseMapper;
    }


    @PostMapping
    public ApplicationResponse createUser(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) {

        CreateCustomerDTO createCustomerDTO = createCustomerRequestMapper.toDTO(createCustomerRequest);

        Customer customer = createCustomerUseCase.exec(createCustomerDTO);

        return ApplicationResponse.builder()
                .success(true)
                .content(createCustomResponseMapper.toResponse(customer))
                .build();
    }

}
