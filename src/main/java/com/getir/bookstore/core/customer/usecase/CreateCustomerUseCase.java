package com.getir.bookstore.core.customer.usecase;

import com.getir.bookstore.common.usecase.BaseUseCase;
import com.getir.bookstore.core.customer.model.domain.Customer;
import com.getir.bookstore.core.customer.model.dto.CreateCustomerDTO;

public interface CreateCustomerUseCase extends BaseUseCase<CreateCustomerDTO, Customer> {
}
