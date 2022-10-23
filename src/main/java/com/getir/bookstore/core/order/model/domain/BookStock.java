package com.getir.bookstore.core.order.model.domain;

import com.getir.bookstore.core.book.model.domain.Book;
import com.getir.bookstore.core.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "BOOK_STOCKS")
@Entity
public class BookStock extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "STOCK_AMOUNT")
    private Integer stockAmount;

    @Version
    private Long version;

}
