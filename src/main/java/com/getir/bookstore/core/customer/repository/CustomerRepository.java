package com.getir.bookstore.core.customer.repository;

import com.getir.bookstore.core.customer.model.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Boolean existsByEmail(String email);

    Boolean existsByCellPhone(String cellPhone);

}
