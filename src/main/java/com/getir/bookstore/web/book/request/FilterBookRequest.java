package com.getir.bookstore.web.book.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterBookRequest {

    private String isbn;

    private String title;

    private String author;

}
