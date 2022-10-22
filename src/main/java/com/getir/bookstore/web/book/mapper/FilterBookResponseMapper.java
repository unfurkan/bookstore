package com.getir.bookstore.web.book.mapper;

import com.getir.bookstore.common.mapper.BaseResponseMapper;
import com.getir.bookstore.core.book.model.domain.Book;
import com.getir.bookstore.web.book.response.FilterBookResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FilterBookResponseMapper extends BaseResponseMapper<FilterBookResponse, Book> {
}
