package com.getir.bookstore.web.book.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class FilterBookResponse {

    private Long id;

    private String isbn;

    private String title;

    private String author;

    private Date publishDate;

    private Integer stockAmount;

    private BigDecimal unitPrice;

}
