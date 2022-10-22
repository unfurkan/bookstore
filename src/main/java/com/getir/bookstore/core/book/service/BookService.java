package com.getir.bookstore.core.book.service;

import com.getir.bookstore.common.pageable.request.Pageable;
import com.getir.bookstore.core.book.model.domain.Book;
import com.getir.bookstore.core.book.model.dto.FilterBookDTO;
import org.springframework.data.domain.Page;

public interface BookService {

    Book save(Book book);

    Book getById(Long bookId);

    Page<Book> filterPaging(Pageable<FilterBookDTO> filterBookDTOPageable);

    Boolean existsByIsbn(String isbn);

}
