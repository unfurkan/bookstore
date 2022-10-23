package com.getir.bookstore.web.order.mapper;

import com.getir.bookstore.common.mapper.BaseResponseMapper;
import com.getir.bookstore.core.order.model.domain.Order;
import com.getir.bookstore.web.order.response.GetOrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {OrderItemResponseMapper.class})
public interface GetOrderResponseMapper extends BaseResponseMapper<GetOrderResponse, Order> {

    @Override
    GetOrderResponse toResponse(Order order);
}
