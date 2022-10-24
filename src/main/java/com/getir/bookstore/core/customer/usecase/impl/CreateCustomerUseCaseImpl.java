package com.getir.bookstore.core.customer.usecase.impl;

import com.getir.bookstore.core.customer.model.domain.Customer;
import com.getir.bookstore.core.customer.model.dto.CreateCustomerDTO;
import com.getir.bookstore.core.customer.service.CustomerService;
import com.getir.bookstore.core.customer.usecase.CreateCustomerUseCase;
import com.getir.bookstore.core.customer.validation.CreateCustomerValidation;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {

    private final CustomerService customerService;
    private final CreateCustomerValidation createCustomerValidation;
    private final PasswordEncoder passwordEncoder;

    public CreateCustomerUseCaseImpl(CustomerService customerService, CreateCustomerValidation createCustomerValidation, PasswordEncoder passwordEncoder) {
        this.customerService = customerService;
        this.createCustomerValidation = createCustomerValidation;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Customer exec(CreateCustomerDTO createCustomerDTO) {

        createCustomerValidation.validate(createCustomerDTO);

        Customer customer = new Customer();
        customer.setFirstName(createCustomerDTO.getFirstName());
        customer.setLastName(createCustomerDTO.getLastName());
        customer.setEmail(createCustomerDTO.getEmail());
        customer.setCellPhone(createCustomerDTO.getCellPhone());
        customer.setPassword(encodePassword(createCustomerDTO));
        return customerService.save(customer);
    }

    private String encodePassword(CreateCustomerDTO createCustomerDTO) {
        return passwordEncoder.encode(createCustomerDTO.getPassword());
    }
}
