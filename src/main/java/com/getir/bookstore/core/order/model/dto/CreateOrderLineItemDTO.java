package com.getir.bookstore.core.order.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderLineItemDTO {

    private Long bookId;

    private Integer quantity;

}
