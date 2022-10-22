package com.getir.bookstore.core.book.repository;

import com.getir.bookstore.core.book.model.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {

    Boolean existsByIsbn(String isbn);

}
