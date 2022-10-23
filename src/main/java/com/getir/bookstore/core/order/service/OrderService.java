package com.getir.bookstore.core.order.service;

import com.getir.bookstore.common.pageable.request.Pageable;
import com.getir.bookstore.core.order.model.domain.Order;
import com.getir.bookstore.core.order.model.dto.FilterOrderDTO;
import com.getir.bookstore.core.order.model.dto.OrderStatisticsDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderService {

    Order save(Order order);

    Order getById(Long orderId);

    List<OrderStatisticsDTO> getOrderStatisticsByCustomerId(Long customerId);

    Page<Order> filterPaging(Pageable<FilterOrderDTO> pageable);

}
