package com.getir.bookstore.web.customer.mapper;


import com.getir.bookstore.common.mapper.BaseResponseMapper;
import com.getir.bookstore.core.customer.model.domain.Customer;
import com.getir.bookstore.web.customer.response.CreateCustomerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateCustomerResponseMapper extends BaseResponseMapper<CreateCustomerResponse, Customer> {
}
