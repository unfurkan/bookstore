package com.getir.bookstore.core.book.model.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Table(name = "BOOKS")
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ISBN", unique = true)
    private String isbn;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "PUBLISH_DATE")
    private Date publishDate;

    @Column(name = "STOCK_AMOUNT")
    private Integer stockAmount;

    @Column(name = "UNIT_PRICE")
    private BigDecimal unitPrice;

}
