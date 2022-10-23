package com.getir.bookstore.common.utils;

import com.getir.bookstore.common.pageable.request.Pageable;
import com.getir.bookstore.common.pageable.response.PageableResponse;
import com.getir.bookstore.core.book.model.domain.Book;
import com.getir.bookstore.web.book.response.FilterBookResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;


public final class PagingUtils {

    public static PageRequest createPageRequest(Pageable pageable) {
        return PageRequest.of(pageable.getPageNumber() - 1, pageable.getPageSize());
    }

    public static PageableResponse getPageableResponse(List responses, Page page) {
        PageableResponse pageableResponse = new PageableResponse<>();
        pageableResponse.setList(responses);
        pageableResponse.setTotalElements(page.getTotalElements());
        pageableResponse.setTotalPages(page.getTotalPages());
        pageableResponse.setPageNumber(page.getPageable().getPageNumber() + 1);
        pageableResponse.setPageSize(page.getPageable().getPageSize());
        return pageableResponse;
    }

}
