package com.getir.bookstore.core.order.service;

import com.getir.bookstore.core.book.model.domain.Book;
import com.getir.bookstore.core.order.model.domain.BookStock;

public interface BookStockService {

    BookStock save(BookStock bookStock);

}
