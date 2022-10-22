package com.getir.bookstore.core.order.usecase.impl;

import com.getir.bookstore.core.book.service.BookService;
import com.getir.bookstore.core.order.model.domain.Order;
import com.getir.bookstore.core.order.model.dto.CreateOrderDTO;
import com.getir.bookstore.core.order.service.OrderService;
import com.getir.bookstore.core.order.usecase.CreateOrderUseCase;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

    private final OrderService orderService;
    private final BookService bookService;

    public CreateOrderUseCaseImpl(OrderService orderService, BookService bookService) {
        this.orderService = orderService;
        this.bookService = bookService;
    }

    @Override
    @Transactional
    public Order exec(CreateOrderDTO createOrderDTO) {
        //TODO
        return null;
    }
}
