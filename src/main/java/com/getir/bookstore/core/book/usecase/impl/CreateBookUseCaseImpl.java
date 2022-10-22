package com.getir.bookstore.core.book.usecase.impl;

import com.getir.bookstore.core.book.model.domain.Book;
import com.getir.bookstore.core.book.model.dto.CreateBookDTO;
import com.getir.bookstore.core.book.service.BookService;
import com.getir.bookstore.core.book.usecase.CreateBookUseCase;
import com.getir.bookstore.core.book.validation.CreateBookValidation;
import org.springframework.stereotype.Service;

@Service
public class CreateBookUseCaseImpl implements CreateBookUseCase {

    private final BookService bookService;
    private final CreateBookValidation createBookValidation;

    public CreateBookUseCaseImpl(BookService bookService, CreateBookValidation createBookValidation) {
        this.bookService = bookService;
        this.createBookValidation = createBookValidation;
    }


    @Override
    public Book exec(CreateBookDTO createBookDTO) {

        //TODO validate isbn
        createBookValidation.validate(createBookDTO);

        Book book = new Book();
        book.setIsbn(createBookDTO.getIsbn());
        book.setTitle(createBookDTO.getTitle());
        book.setAuthor(createBookDTO.getAuthor());
        book.setUnitPrice(createBookDTO.getUnitPrice());
        book.setStockAmount(createBookDTO.getStockAmount());
        book.setPublishDate(createBookDTO.getPublishDate());

        return bookService.save(book);
    }
}
