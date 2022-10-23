package com.getir.bookstore.core.order.service.impl;

import com.getir.bookstore.common.pageable.request.Pageable;
import com.getir.bookstore.common.utils.PagingUtils;
import com.getir.bookstore.core.order.model.domain.Order;
import com.getir.bookstore.core.order.model.dto.FilterOrderDTO;
import com.getir.bookstore.core.order.model.dto.OrderStatisticsDTO;
import com.getir.bookstore.core.order.repository.OrderRepository;
import com.getir.bookstore.core.order.service.OrderService;
import com.getir.bookstore.core.order.specification.FilterOrderSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderServiceImpl implements OrderService {

    public static final String ORDER_NOT_FOUND = "order.not.found";

    private final OrderRepository orderRepository;
    private final FilterOrderSpecification filterOrderSpecification;

    public OrderServiceImpl(OrderRepository orderRepository, FilterOrderSpecification filterOrderSpecification) {
        this.orderRepository = orderRepository;
        this.filterOrderSpecification = filterOrderSpecification;
    }


    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new NoSuchElementException(ORDER_NOT_FOUND));
    }

    @Override
    public List<OrderStatisticsDTO> getOrderStatisticsByCustomerId(Long customerId) {
        return orderRepository.getOrderStatisticsByCustomerId(customerId);
    }

    @Override
    public Page<Order> filterPaging(Pageable<FilterOrderDTO> pageable) {
        PageRequest pageRequest = PagingUtils.createPageRequest(pageable);
        return orderRepository.findAll(filterOrderSpecification.filter(pageable.getFilter()), pageRequest);
    }

}
