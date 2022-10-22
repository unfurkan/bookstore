package com.getir.bookstore.common.specification;

import org.springframework.data.jpa.domain.Specification;

public interface BaseSpecification<Entity, Filter> {

    Specification<Entity> filter(Filter filter);

}
