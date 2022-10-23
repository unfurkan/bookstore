package com.getir.bookstore.core.order.service.impl;

import com.getir.bookstore.core.order.model.domain.BookStock;
import com.getir.bookstore.core.order.repository.BookStockRepository;
import com.getir.bookstore.core.order.service.BookStockService;
import org.springframework.stereotype.Service;


@Service
public class BookStockServiceImpl implements BookStockService {

    private final BookStockRepository bookStockRepository;

    public BookStockServiceImpl(BookStockRepository bookStockRepository) {
        this.bookStockRepository = bookStockRepository;
    }

    @Override
    public BookStock save(BookStock bookStock) {
        return bookStockRepository.save(bookStock);
    }

}
