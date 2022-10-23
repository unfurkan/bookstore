package com.getir.bookstore.core.order.repository;

import com.getir.bookstore.core.order.model.dto.OrderStatisticsDTO;
import com.getir.bookstore.core.order.model.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>, JpaSpecificationExecutor<OrderItem> {
}
