package com.getir.bookstore.core.order.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FilterOrderDTO {

    private Date startDate;

    private Date endDate;

}
