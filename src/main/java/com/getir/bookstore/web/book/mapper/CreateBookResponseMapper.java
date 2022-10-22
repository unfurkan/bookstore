package com.getir.bookstore.web.book.mapper;

import com.getir.bookstore.common.mapper.BaseResponseMapper;
import com.getir.bookstore.core.book.model.domain.Book;
import com.getir.bookstore.web.book.response.CreateBookResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateBookResponseMapper extends BaseResponseMapper<CreateBookResponse, Book> {
}
