package com.getir.bookstore.core.book.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class CreateBookDTO {

    private String isbn;

    private String title;

    private String author;

    private Date publishDate;

    private Integer stockAmount;

    private BigDecimal unitPrice;

}
