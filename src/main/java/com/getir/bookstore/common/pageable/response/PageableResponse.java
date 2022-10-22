package com.getir.bookstore.common.pageable.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageableResponse<T> {

    private List<T> list;

    private int totalPages;

    private long totalElements;

    private int pageNumber;

    private int pageSize;

}
