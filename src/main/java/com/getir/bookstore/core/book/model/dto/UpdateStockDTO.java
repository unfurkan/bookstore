package com.getir.bookstore.core.book.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStockDTO {

    private Long id;

    private Integer stockAmount;

}
