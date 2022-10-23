package com.getir.bookstore.web.order.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class CreateOrderRequest {

    @NotNull(message = "not.null.customer.id")
    private Long customerId;

    private String note;

    @NotBlank(message = "not.blank.order.delivery.address")
    private String deliveryAddress;

    @NotBlank(message = "not.blank.order.invoice.address")
    private String invoiceAddress;

    @Valid
    @NotEmpty(message = "not.empty.order.items")
    private List<CreateOrderItemRequest> orderItems;

}
