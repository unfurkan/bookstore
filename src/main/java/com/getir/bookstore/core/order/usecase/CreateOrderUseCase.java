package com.getir.bookstore.core.order.usecase;

import com.getir.bookstore.common.usecase.BaseUseCase;
import com.getir.bookstore.core.order.model.domain.Order;
import com.getir.bookstore.core.order.model.dto.CreateOrderDTO;

public interface CreateOrderUseCase extends BaseUseCase<CreateOrderDTO, Order> {
}
