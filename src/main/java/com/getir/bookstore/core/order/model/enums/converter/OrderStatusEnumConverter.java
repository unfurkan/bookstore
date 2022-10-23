package com.getir.bookstore.core.order.model.enums.converter;

import com.getir.bookstore.core.order.model.enums.Month;
import com.getir.bookstore.core.order.model.enums.OrderStatus;

import javax.persistence.AttributeConverter;
import java.util.Objects;

public class OrderStatusEnumConverter implements AttributeConverter<OrderStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(OrderStatus orderStatus) {

        if (Objects.isNull(orderStatus)) {
            return null;
        }

        return orderStatus.getValue();
    }

    @Override
    public OrderStatus convertToEntityAttribute(Integer value) {

        if (Objects.isNull(value)) {
            return null;
        }

        return OrderStatus.getByValue(value);
    }
}
