package com.getir.bookstore.web.customer.mapper;

import com.getir.bookstore.common.mapper.BaseRequestMapper;
import com.getir.bookstore.common.pageable.request.Pageable;
import com.getir.bookstore.core.customer.model.dto.FilterCustomerDTO;
import com.getir.bookstore.web.customer.request.FilterCustomerRequest;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface FilterCustomerRequestMapper extends BaseRequestMapper<Pageable<FilterCustomerDTO>, Pageable<FilterCustomerRequest>> {
}
