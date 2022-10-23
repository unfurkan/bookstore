package com.getir.bookstore.web.customer.mapper;

import com.getir.bookstore.common.mapper.BaseResponseMapper;
import com.getir.bookstore.core.order.model.dto.OrderStatisticsDTO;
import com.getir.bookstore.core.order.model.enums.Month;
import com.getir.bookstore.web.customer.response.OrderStatisticsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(componentModel = "spring")
public abstract class OrderStatisticsResponseMapper implements BaseResponseMapper<OrderStatisticsResponse, OrderStatisticsDTO> {

    @Autowired
    private MessageSource messageSource;

    @Mapping(source = "month",target = "month",qualifiedByName = "setMonth")
    @Override
    public abstract OrderStatisticsResponse toResponse(OrderStatisticsDTO orderTest);

    @Named("setMonth")
     String setMonth(String value){
        return messageSource.getMessage( Month.getByValue(value).getDescription(),null, LocaleContextHolder.getLocale());
    }
}
