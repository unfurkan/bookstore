package com.getir.bookstore.web.order.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateOrderItemRequest {

    @NotNull(message = "not.null.book.id")
    private Long bookId;

    @NotNull(message = "not.null.order.item.quantity")
    @Min(value =0,message = "min.order.item.quantity")
    private Integer quantity;


}
