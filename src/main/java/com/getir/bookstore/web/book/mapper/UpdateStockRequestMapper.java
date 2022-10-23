package com.getir.bookstore.web.book.mapper;

import com.getir.bookstore.common.mapper.BaseRequestMapper;
import com.getir.bookstore.core.book.model.domain.Book;
import com.getir.bookstore.core.book.model.dto.UpdateStockDTO;
import com.getir.bookstore.web.book.request.UpdateStockRequest;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UpdateStockRequestMapper extends BaseRequestMapper<UpdateStockDTO, UpdateStockRequest> {
}
