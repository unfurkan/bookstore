package com.getir.bookstore.common.utils;

import com.getir.bookstore.common.pageable.request.Pageable;
import org.springframework.data.domain.PageRequest;


public final class PagingUtils {

    public static PageRequest createPageRequest(Pageable pageable) {
        return PageRequest.of(pageable.getPageNumber() - 1, pageable.getPageSize());
    }

}
