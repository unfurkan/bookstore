package com.getir.bookstore.web.book.mapper;

import com.getir.bookstore.common.mapper.BaseRequestMapper;
import com.getir.bookstore.common.pageable.request.Pageable;
import com.getir.bookstore.core.book.model.dto.FilterBookDTO;
import com.getir.bookstore.web.book.request.FilterBookRequest;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface FilterBookRequestMapper extends BaseRequestMapper<Pageable<FilterBookDTO>, Pageable<FilterBookRequest>> {
}
