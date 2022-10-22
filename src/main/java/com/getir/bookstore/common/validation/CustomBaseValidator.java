package com.getir.bookstore.common.validation;

import com.getir.bookstore.common.response.ApplicationMessageResponse;

import java.util.List;

public interface CustomBaseValidator<T> {

    List<ApplicationMessageResponse> validate(T entity);

}
