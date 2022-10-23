package com.getir.bookstore.core.order.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum Month {

    JAN("01","month.january"),
    FEBRUARY("02","month.february"),
    MARCH("03","month.march"),
    APRIL("04","month.april"),
    MAY("05","month.may"),
    JUNE("06","month.june"),
    JULY("07","month.july"),
    AUGUST("08","month.august"),
    SEPTEMBER("09","month.september"),
    OCTOBER("10","month.october"),
    NOVEMBER("11","month.november"),
    DECEMBER("12","month.december");

    private String value;
    private String description;

    public static Month getByValue(String value) {

        if (Objects.isNull(value)) {
            return null;
        }

        return Stream.of(Month.values())
                .filter(month -> month.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
