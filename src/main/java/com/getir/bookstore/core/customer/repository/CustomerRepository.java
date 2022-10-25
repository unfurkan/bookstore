package com.getir.bookstore.core.customer.repository;

import com.getir.bookstore.core.customer.model.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

    Boolean existsByEmail(String email);

    Boolean existsByCellPhone(String cellPhone);

    Optional<Customer> findByEmail(String username);

}
