package com.getir.bookstore.web.customer.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderStatisticsResponse {

    private String month;

    private Long orderCount;

    private Long bookCount;

    private BigDecimal totalAmount;

}
