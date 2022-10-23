package com.getir.bookstore.core.order.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Getter
@NoArgsConstructor
public class OrderStatisticsDTO {

    private String month;

    private Long orderCount;

    private Long bookCount;

    private BigDecimal totalAmount;

    public OrderStatisticsDTO(String month, Long orderCount, Long bookCount, BigDecimal totalAmount) {
        this.month = month;
        this.orderCount = orderCount;
        this.bookCount = bookCount;
        this.totalAmount = totalAmount;
    }
}
