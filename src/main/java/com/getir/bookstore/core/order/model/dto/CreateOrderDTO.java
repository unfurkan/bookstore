package com.getir.bookstore.core.order.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateOrderDTO {

    private Long customerId;

    private String note;

    private String deliveryAddress;

    private String invoiceAddress;

    private List<CreateOrderLineItemDTO> orderItems;

}
