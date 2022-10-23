package com.getir.bookstore.web.order.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class GetOrderResponse {

    private Long id;

    private String note;

    private String deliveryAddress;

    private String invoiceAddress;

    private BigDecimal totalPrice;

    private OrderCustomerResponse customer;

    private List<OrderItemResponse> orderItems;

}
