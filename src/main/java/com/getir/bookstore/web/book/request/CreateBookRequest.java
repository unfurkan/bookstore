package com.getir.bookstore.web.book.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class CreateBookRequest {

    @NotBlank(message = "not.blank.book.isbn")
    private String isbn;

    @NotBlank(message = "not.blank.book.title")
    private String title;

    @NotBlank(message = "not.blank.book.author")
    private String author;

    @NotNull(message = "not.null.book.publish.date")
    private Date publishDate;

    @NotNull(message = "not.null.book.stock.amount")
    @Min(value = 0, message = "min.book.stock.amount")
    private Integer stockAmount;

    @NotNull(message = "not.null.book.unit.price")
    @DecimalMin(value = "0", inclusive = false, message = "min.book.unit.price")
    private BigDecimal unitPrice;

}
