package com.getir.bookstore.web.order.mapper;


import com.getir.bookstore.common.mapper.BaseRequestMapper;
import com.getir.bookstore.common.pageable.request.Pageable;
import com.getir.bookstore.core.order.model.dto.FilterOrderDTO;
import com.getir.bookstore.web.order.request.FilterOrderRequest;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface FilterOrderRequestMapper extends BaseRequestMapper<Pageable<FilterOrderDTO>, Pageable<FilterOrderRequest>> {
}
