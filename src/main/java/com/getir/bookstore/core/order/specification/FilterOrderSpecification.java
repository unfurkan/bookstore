package com.getir.bookstore.core.order.specification;

import com.getir.bookstore.common.specification.BaseSpecification;
import com.getir.bookstore.common.utils.StringUtils;
import com.getir.bookstore.core.book.model.domain.Book;
import com.getir.bookstore.core.order.model.domain.Order;
import com.getir.bookstore.core.order.model.domain.OrderItem;
import com.getir.bookstore.core.order.model.dto.FilterOrderDTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Component
public class FilterOrderSpecification implements BaseSpecification<Order, FilterOrderDTO> {

    public static final String CREATED_ON = "createdOn";
    public static final String CUSTOMER = "customer";
    public static final String ID = "id";
    public static final String ORDER_ITEMS = "orderItems";
    public static final String BOOK = "book";
    public static final String TITLE = "title";

    @Override
    public Specification<Order> filter(FilterOrderDTO filterOrderDTO) {

        return (root, criteria, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (Objects.nonNull(filterOrderDTO.getStartDate())) {
                predicates.add(cb.greaterThanOrEqualTo(root.get(CREATED_ON), filterOrderDTO.getStartDate()));
            }

            if (Objects.nonNull(filterOrderDTO.getEndDate())) {
                predicates.add(cb.lessThanOrEqualTo(root.get(CREATED_ON), filterOrderDTO.getEndDate()));
            }

            if (Objects.nonNull(filterOrderDTO.getCustomerId())) {
                predicates.add(cb.equal(root.get(CUSTOMER).get(ID), filterOrderDTO.getCustomerId()));
            }

            if (Objects.nonNull(filterOrderDTO.getBookTitle())) {
                Join<Order, Book> orderBookJoin =root.join(ORDER_ITEMS).join(BOOK);
                predicates.add(cb.like(orderBookJoin.get(TITLE), "%" + filterOrderDTO.getBookTitle() + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));

        };
    }
}
