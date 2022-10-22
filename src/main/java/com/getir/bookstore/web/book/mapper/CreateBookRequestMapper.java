package com.getir.bookstore.web.book.mapper;

import com.getir.bookstore.common.mapper.BaseRequestMapper;
import com.getir.bookstore.core.book.model.dto.CreateBookDTO;
import com.getir.bookstore.web.book.request.CreateBookRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateBookRequestMapper extends BaseRequestMapper<CreateBookDTO, CreateBookRequest> {
}
