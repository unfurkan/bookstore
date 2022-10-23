package com.getir.bookstore.web.order.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderItemResponse {

    private Long id;

    private String bookTitle;

    private String bookAuthor;

    private String bookIsbn;

    private Integer quantity;

    private BigDecimal unitPrice;

}
