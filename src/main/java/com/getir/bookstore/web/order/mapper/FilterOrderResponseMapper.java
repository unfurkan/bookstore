package com.getir.bookstore.web.order.mapper;

import com.getir.bookstore.common.mapper.BaseResponseMapper;
import com.getir.bookstore.core.order.model.domain.Order;
import com.getir.bookstore.web.order.response.FilterOrderResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FilterOrderResponseMapper extends BaseResponseMapper<FilterOrderResponse, Order> {

    @Override
    FilterOrderResponse toResponse(Order order);
}
