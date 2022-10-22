package com.getir.bookstore.core.book.service.impl;

import com.getir.bookstore.common.pageable.request.Pageable;
import com.getir.bookstore.common.utils.PagingUtils;
import com.getir.bookstore.core.book.model.domain.Book;
import com.getir.bookstore.core.book.model.dto.FilterBookDTO;
import com.getir.bookstore.core.book.repository.BookRepository;
import com.getir.bookstore.core.book.service.BookService;
import com.getir.bookstore.web.book.specification.FilterBookSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class BookServiceImpl implements BookService {

    public static final String BOOK_NOT_FOUND = "book.not.found";

    private final BookRepository bookRepository;
    private final FilterBookSpecification filterBookSpecification;

    public BookServiceImpl(BookRepository bookRepository, FilterBookSpecification filterBookSpecification) {
        this.bookRepository = bookRepository;
        this.filterBookSpecification = filterBookSpecification;
    }


    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(() -> new NoSuchElementException(BOOK_NOT_FOUND));
    }

    @Override
    public Page<Book> filterPaging(Pageable<FilterBookDTO> filterBookDTOPageable) {
        PageRequest pageRequest = PagingUtils.createPageRequest(filterBookDTOPageable);
        return bookRepository.findAll(filterBookSpecification.filter(filterBookDTOPageable.getFilter()), pageRequest);
    }

    @Override
    public Boolean existsByIsbn(String isbn) {
        return bookRepository.existsByIsbn(isbn);
    }

}
