package com.getir.bookstore.web.order.mapper;

import com.getir.bookstore.common.mapper.BaseRequestMapper;
import com.getir.bookstore.core.order.model.dto.CreateOrderDTO;
import com.getir.bookstore.web.order.request.CreateOrderRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateOrderRequestMapper extends BaseRequestMapper<CreateOrderDTO, CreateOrderRequest> {
}
