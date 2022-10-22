package com.getir.bookstore.core.order.service.impl;

import com.getir.bookstore.core.order.model.domain.OrderItem;
import com.getir.bookstore.core.order.repository.OrderItemRepository;
import com.getir.bookstore.core.order.service.OrderItemService;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }


    @Override
    public OrderItem save(OrderItem order) {
        return orderItemRepository.save(order);
    }
}
