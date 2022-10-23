package com.getir.bookstore.core.book.usecase.impl;

import com.getir.bookstore.core.book.model.domain.Book;
import com.getir.bookstore.core.book.model.dto.CreateBookDTO;
import com.getir.bookstore.core.book.service.BookService;
import com.getir.bookstore.core.book.usecase.CreateBookUseCase;
import com.getir.bookstore.core.book.validation.CreateBookValidation;
import com.getir.bookstore.core.order.model.domain.BookStock;
import com.getir.bookstore.core.order.service.BookStockService;
import org.springframework.stereotype.Service;

@Service
public class CreateBookUseCaseImpl implements CreateBookUseCase {

    private final BookService bookService;
    private final CreateBookValidation createBookValidation;
    private final BookStockService bookStockService;

    public CreateBookUseCaseImpl(BookService bookService, CreateBookValidation createBookValidation, BookStockService bookStockService) {
        this.bookService = bookService;
        this.createBookValidation = createBookValidation;
        this.bookStockService = bookStockService;
    }


    @Override
    public Book exec(CreateBookDTO createBookDTO) {

        createBookValidation.validate(createBookDTO);

        Book book = new Book();
        book.setIsbn(createBookDTO.getIsbn());
        book.setTitle(createBookDTO.getTitle());
        book.setAuthor(createBookDTO.getAuthor());
        book.setUnitPrice(createBookDTO.getUnitPrice());
        book.setPublishDate(createBookDTO.getPublishDate());

        book.setStock(createBookStock(createBookDTO.getStockAmount()));

        return bookService.save(book);
    }

    private BookStock createBookStock(Integer stockAmount) {
        BookStock bookStock = new BookStock();
        bookStock.setStockAmount(stockAmount);
        return bookStockService.save(bookStock);
    }
}
