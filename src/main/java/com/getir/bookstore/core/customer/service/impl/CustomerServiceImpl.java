package com.getir.bookstore.core.customer.service.impl;

import com.getir.bookstore.common.pageable.request.Pageable;
import com.getir.bookstore.common.utils.PagingUtils;
import com.getir.bookstore.core.customer.model.domain.Customer;
import com.getir.bookstore.core.customer.model.dto.FilterCustomerDTO;
import com.getir.bookstore.core.customer.repository.CustomerRepository;
import com.getir.bookstore.core.customer.service.CustomerService;
import com.getir.bookstore.core.customer.specification.FilterCustomerSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final FilterCustomerSpecification filterCustomerSpecification;

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

    @Override
    public Page<Customer> filterPaging(Pageable<FilterCustomerDTO> filterCustomerDTOPagable) {
        PageRequest pageRequest = PagingUtils.createPageRequest(filterCustomerDTOPagable);
        return customerRepository.findAll(filterCustomerSpecification.filter(filterCustomerDTOPagable.getFilter()), pageRequest);
    }
}
