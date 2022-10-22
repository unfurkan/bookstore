package com.getir.bookstore.core.order.service;

import com.getir.bookstore.core.order.model.domain.Order;
import com.getir.bookstore.core.order.model.domain.OrderItem;

public interface OrderItemService {

    OrderItem save(OrderItem order);

}
