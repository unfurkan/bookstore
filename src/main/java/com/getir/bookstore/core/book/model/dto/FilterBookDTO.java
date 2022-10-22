package com.getir.bookstore.core.book.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterBookDTO {

    private String isbn;

    private String title;

    private String author;

}
