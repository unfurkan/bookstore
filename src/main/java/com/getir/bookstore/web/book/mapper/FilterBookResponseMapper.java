package com.getir.bookstore.web.book.mapper;

import com.getir.bookstore.common.mapper.BaseResponseMapper;
import com.getir.bookstore.core.book.model.domain.Book;
import com.getir.bookstore.web.book.response.FilterBookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FilterBookResponseMapper extends BaseResponseMapper<FilterBookResponse, Book> {

    @Mapping(source = "stock.stockAmount",target = "stockAmount")
    @Override
    FilterBookResponse toResponse(Book book);
}
