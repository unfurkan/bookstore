package com.getir.bookstore.web.order.mapper;

import com.getir.bookstore.common.mapper.BaseResponseMapper;
import com.getir.bookstore.core.order.model.domain.Order;
import com.getir.bookstore.web.order.response.CreateOrderResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateOrderResponseMapper extends BaseResponseMapper<CreateOrderResponse, Order> {
}
