package com.getir.bookstore.core.order.service;

import com.getir.bookstore.core.order.model.domain.Order;
import com.getir.bookstore.core.order.model.dto.OrderTest;

import java.util.List;

public interface OrderService {

    Order save(Order order);

    Order getById(Long orderId);

    List<OrderTest> getOrderStatisticsByCustomerId(Long customerId);

}
