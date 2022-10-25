package com.getir.bookstore.core.customer.service;

import com.getir.bookstore.common.pageable.request.Pageable;
import com.getir.bookstore.core.customer.model.domain.Customer;
import com.getir.bookstore.core.customer.model.dto.FilterCustomerDTO;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface CustomerService {

    Customer getById(Long customerId);

    Customer save(Customer customer);

    Boolean existsByEmail(String email);

    Boolean existsByCellPhone(String cellPhone);

    Optional<Customer> findByEmail(String username);

    Page<Customer> filterPaging(Pageable<FilterCustomerDTO> filterCustomerDTOPagable);

}
