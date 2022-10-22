package com.getir.bookstore.core.order.service;

import com.getir.bookstore.core.order.model.domain.Order;

public interface OrderService {

    Order save(Order order);

    Order getById(Long orderId);

}
