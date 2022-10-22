package com.getir.bookstore.common.mapper;


public interface BaseRequestMapper<DTO, Request> {

    DTO toDTO(Request request);

}
