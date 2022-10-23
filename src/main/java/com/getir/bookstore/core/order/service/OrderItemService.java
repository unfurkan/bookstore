package com.getir.bookstore.core.order.service;

import com.getir.bookstore.core.order.model.domain.OrderItem;

import java.util.List;

public interface OrderItemService {

    OrderItem save(OrderItem order);

    List<OrderItem> saveAll(List<OrderItem> orderItems);

}
