package com.getir.bookstore.core.book.usecase.impl;

import com.getir.bookstore.core.book.model.domain.Book;
import com.getir.bookstore.core.book.model.dto.UpdateStockDTO;
import com.getir.bookstore.core.book.service.BookService;
import com.getir.bookstore.core.book.usecase.UpdateStockUseCase;
import com.getir.bookstore.core.order.model.domain.BookStock;
import com.getir.bookstore.core.order.service.BookStockService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UpdateStockUseCaseImpl implements UpdateStockUseCase {

    private final BookService bookService;
    private final BookStockService bookStockService;

    public static final String MIN_STOCK_AMOUNT = "min.book.stock.amount";

    public UpdateStockUseCaseImpl(BookService bookService, BookStockService bookStockService) {
        this.bookService = bookService;
        this.bookStockService = bookStockService;
    }

    @Override
    public BookStock exec(UpdateStockDTO updateStockDTO) {

        if (updateStockDTO.getStockAmount() < 0) {
            throw new RuntimeException(MIN_STOCK_AMOUNT);
        }

        Book book = bookService.getById(updateStockDTO.getId());

        BookStock stock = book.getStock();
        stock.setStockAmount(updateStockDTO.getStockAmount());
        bookStockService.save(stock);

        return stock;
    }
}
