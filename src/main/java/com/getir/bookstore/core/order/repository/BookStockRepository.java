package com.getir.bookstore.core.order.repository;

import com.getir.bookstore.core.order.model.domain.BookStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookStockRepository extends JpaRepository<BookStock, Long>, JpaSpecificationExecutor<BookStock> {
}
