package com.getir.bookstore.core.order.service.impl;

import com.getir.bookstore.core.order.model.domain.Order;
import com.getir.bookstore.core.order.model.dto.OrderTest;
import com.getir.bookstore.core.order.repository.OrderRepository;
import com.getir.bookstore.core.order.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderServiceImpl implements OrderService {

    public static final String ORDER_NOT_FOUND = "order.not.found";

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
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
    public List<OrderTest> getOrderStatisticsByCustomerId(Long customerId) {
        return orderRepository.getOrderStatisticsByCustomerId(customerId);
    }

}
