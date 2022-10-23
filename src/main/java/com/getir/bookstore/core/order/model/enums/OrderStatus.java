package com.getir.bookstore.core.order.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum OrderStatus {

    CREATED(1,"order.created"),
    CANCELLED(2,"order.cancelled"),
    DELIVERED(3,"order.delivered");

    private Integer value;
    private String description;

    public static OrderStatus getByValue(Integer value) {

        if (Objects.isNull(value)) {
            return null;
        }

        return Stream.of(OrderStatus.values())
                .filter(orderStatus -> orderStatus.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
