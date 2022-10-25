package com.getir.bookstore.web.order.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FilterOrderRequest {

    private Long customerId;

    private Date startDate;

    private Date endDate;

    private String bookTitle;

}
