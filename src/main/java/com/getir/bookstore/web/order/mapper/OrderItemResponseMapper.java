package com.getir.bookstore.web.order.mapper;

import com.getir.bookstore.common.mapper.BaseResponseMapper;
import com.getir.bookstore.core.order.model.domain.OrderItem;
import com.getir.bookstore.web.order.response.OrderItemResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderItemResponseMapper extends BaseResponseMapper<OrderItemResponse, OrderItem> {

    @Mapping(source = "book.title",target = "bookTitle")
    @Mapping(source = "book.author",target = "bookAuthor")
    @Mapping(source = "book.isbn",target = "bookIsbn")
    @Override
    OrderItemResponse toResponse(OrderItem orderItem);
}
