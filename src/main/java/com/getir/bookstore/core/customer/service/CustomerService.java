package com.getir.bookstore.core.customer.service;

import com.getir.bookstore.core.customer.model.domain.Customer;

public interface CustomerService {

    Customer getById(Long customerId);

    Customer save(Customer customer);

    Boolean existsByEmail(String email);

    Boolean existsByCellPhone(String cellPhone);

}
