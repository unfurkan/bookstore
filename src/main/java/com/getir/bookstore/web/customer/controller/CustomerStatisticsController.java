package com.getir.bookstore.web.customer.controller;


import com.getir.bookstore.common.response.ApplicationResponse;
import com.getir.bookstore.core.order.model.dto.OrderTest;
import com.getir.bookstore.core.order.service.OrderService;
import com.getir.bookstore.web.customer.mapper.OrderStatisticsResponseMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/customers")
@RestController
public class CustomerStatisticsController {

    private final OrderService orderService;
    private final OrderStatisticsResponseMapper orderStatisticsResponseMapper;

    public CustomerStatisticsController(OrderService orderService, OrderStatisticsResponseMapper orderStatisticsResponseMapper) {
        this.orderService = orderService;
        this.orderStatisticsResponseMapper = orderStatisticsResponseMapper;
    }


    @GetMapping("/{id}/statistics")
    public ApplicationResponse getStatistics(@PathVariable("id") Long customerId) {

        List<OrderTest> statisticsByCustomerId = orderService.getOrderStatisticsByCustomerId(customerId);

        return ApplicationResponse.builder()
                .success(true)
                .content(orderStatisticsResponseMapper.toListResponse(statisticsByCustomerId))
                .build();
    }

}
