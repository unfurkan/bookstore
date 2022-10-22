package com.getir.bookstore.core.order.repository;

import com.getir.bookstore.core.order.model.domain.Order;
import com.getir.bookstore.core.order.model.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long>, JpaSpecificationExecutor<OrderItem> {
}
