package com.getir.bookstore.common.pageable.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Pageable<T> {

    @NotNull(message = "not.null.page.size")
    @Min(value = 1, message = "not.null.page.size.value")
    private Integer pageSize;

    @NotNull(message = "not.null.page.number")
    @Min(value = 1, message = "not.null.page.number.value")
    private Integer pageNumber;

    @Valid
    private T filter;

}
