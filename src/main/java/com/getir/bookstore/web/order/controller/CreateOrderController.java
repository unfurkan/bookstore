package com.getir.bookstore.web.order.controller;

import com.getir.bookstore.common.response.ApplicationResponse;
import com.getir.bookstore.common.utils.PagingUtils;
import com.getir.bookstore.core.order.model.domain.Order;
import com.getir.bookstore.core.order.usecase.CreateOrderUseCase;
import com.getir.bookstore.web.order.mapper.CreateOrderRequestMapper;
import com.getir.bookstore.web.order.mapper.CreateOrderResponseMapper;
import com.getir.bookstore.web.order.request.CreateOrderRequest;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/v1/orders")
@RestController
public class CreateOrderController {

    private final CreateOrderUseCase createOrderUseCase;
    private final CreateOrderRequestMapper createOrderRequestMapper;
    private final CreateOrderResponseMapper createOrderResponseMapper;

    public static final String BOOK_STOCK_UPDATED = "book.stock.updated";

    public CreateOrderController(CreateOrderUseCase createOrderUseCase, CreateOrderRequestMapper createOrderRequestMapper, CreateOrderResponseMapper createOrderResponseMapper) {
        this.createOrderUseCase = createOrderUseCase;
        this.createOrderRequestMapper = createOrderRequestMapper;
        this.createOrderResponseMapper = createOrderResponseMapper;
    }


    @PostMapping
    ApplicationResponse createOrder(@Valid @RequestBody CreateOrderRequest createOrderRequest) {

        try {

            Order order = createOrderUseCase.exec(createOrderRequestMapper.toDTO(createOrderRequest));
            return createResponse(order);

        } catch (OptimisticLockingFailureException optimisticLockingFailureException) {
            throw new RuntimeException(BOOK_STOCK_UPDATED);
        }

    }

    private ApplicationResponse createResponse(Order order) {
        return ApplicationResponse.builder()
                .success(true)
                .content(createOrderResponseMapper.toResponse(order))
                .build();
    }
}
