package com.getir.bookstore.core.order.model.enums.converter;

import com.getir.bookstore.core.order.model.enums.Month;

import javax.persistence.AttributeConverter;
import java.util.Objects;
import java.util.stream.Stream;

public class MonthEnumConverter implements AttributeConverter<Month, String> {

    @Override
    public String convertToDatabaseColumn(Month month) {

        if (Objects.isNull(month)) {
            return null;
        }

        return month.getValue();
    }

    @Override
    public Month convertToEntityAttribute(String value) {

        if (Objects.isNull(value)) {
            return null;
        }

        return Month.getByValue(value);
    }
}
