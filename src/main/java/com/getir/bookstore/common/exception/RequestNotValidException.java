package com.getir.bookstore.common.exception;

import com.getir.bookstore.common.response.ApplicationMessageResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class RequestNotValidException extends RuntimeException {

    private final List<ApplicationMessageResponse> fieldList;

}
