package com.getir.bookstore.core.order.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Getter
@NoArgsConstructor
public class OrderTest {

    private String month;

    private Long orderCount;

    private Long bookCount;

    private BigDecimal totalAmount;

    public OrderTest(String month, Long orderCount, Long bookCount, BigDecimal totalAmount) {
        this.month = month;
        this.orderCount = orderCount;
        this.bookCount = bookCount;
        this.totalAmount = totalAmount;
    }
}
