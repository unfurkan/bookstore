package com.getir.bookstore.web.order.controller;

import com.getir.bookstore.common.response.ApplicationResponse;
import com.getir.bookstore.core.order.model.domain.Order;
import com.getir.bookstore.core.order.service.OrderService;
import com.getir.bookstore.web.order.mapper.GetOrderResponseMapper;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/orders")
@RestController
public class GetOrderController {

    private final GetOrderResponseMapper getOrderResponseMapper;
    private final OrderService orderService;

    public GetOrderController(GetOrderResponseMapper getOrderResponseMapper, OrderService orderService) {
        this.getOrderResponseMapper = getOrderResponseMapper;
        this.orderService = orderService;
    }


    @GetMapping("/{id}")
    public ApplicationResponse filterOrders(@PathVariable("id") Long orderId) {
        Order order = orderService.getById(orderId);
        return ApplicationResponse.builder()
                .success(true)
                .content(getOrderResponseMapper.toResponse(order))
                .build();
    }
}
