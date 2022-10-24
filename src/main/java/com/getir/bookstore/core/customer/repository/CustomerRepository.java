package com.getir.bookstore.core.customer.repository;

import com.getir.bookstore.core.customer.model.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Boolean existsByEmail(String email);

    Boolean existsByCellPhone(String cellPhone);

    Optional<Customer> findByEmail(String username);

}
