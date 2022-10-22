package com.getir.bookstore.web.customer.mapper;

import com.getir.bookstore.common.mapper.BaseRequestMapper;
import com.getir.bookstore.core.customer.model.dto.CreateCustomerDTO;
import com.getir.bookstore.web.customer.request.CreateCustomerRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateCustomerRequestMapper extends BaseRequestMapper<CreateCustomerDTO, CreateCustomerRequest> {
}
