package com.getir.bookstore.core.customer.service.impl;

import com.getir.bookstore.core.customer.model.domain.Customer;
import com.getir.bookstore.core.customer.repository.CustomerRepository;
import com.getir.bookstore.core.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public static final String CUSTOMER_NOT_FOUND = "customer.not.found";


    @Override
    public Customer getById(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new NoSuchElementException(CUSTOMER_NOT_FOUND));
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }

    @Override
    public Boolean existsByCellPhone(String cellPhone) {
        return customerRepository.existsByCellPhone(cellPhone);
    }

    @Override
    public Optional<Customer> findByEmail(String username) {
        return customerRepository.findByEmail(username);
    }
}
