package com.getir.bookstore.web.book.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateStockRequest {

    @NotNull(message = "not.null.book.id")
    private Long id;

    @NotNull(message = "not.null.book.stock.amount")
    @Min(value = 0, message = "min.book.stock.amount")
    private Integer stockAmount;

}
