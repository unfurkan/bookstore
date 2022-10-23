package com.getir.bookstore.web.order.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class FilterOrderResponse {

    private Long id;

    private String code;

    private BigDecimal totalPrice;

    private String status;

    private Date createdOn;

}
