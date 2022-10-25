package com.getir.bookstore.core.customer.specification;

import com.getir.bookstore.common.specification.BaseSpecification;
import com.getir.bookstore.core.customer.model.domain.Customer;
import com.getir.bookstore.core.customer.model.dto.FilterCustomerDTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class FilterCustomerSpecification implements BaseSpecification<Customer, FilterCustomerDTO> {

    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";

    @Override
    public Specification<Customer> filter(FilterCustomerDTO filterCustomerDTO) {

        return (root, criteria, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (Objects.nonNull(filterCustomerDTO.getCustomerName())) {

                Expression<String> firstName = cb.concat(root.get(FIRST_NAME), " ");
                Expression<String> fullName = cb.concat(firstName, root.get(LAST_NAME));

                predicates.add(cb.like(fullName, "%" + filterCustomerDTO.getCustomerName() + "%"));

            }

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));

        };
    }
}
