package com.getir.bookstore.common;

import com.getir.bookstore.common.mapper.BaseResponseMapper;
import com.getir.bookstore.common.pageable.response.PageableResponse;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface PageableResponseMapper extends BaseResponseMapper<PageableResponse, Page> {
}
