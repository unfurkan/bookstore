package com.getir.bookstore.core.book.usecase;

import com.getir.bookstore.common.usecase.BaseUseCase;
import com.getir.bookstore.core.book.model.domain.Book;
import com.getir.bookstore.core.book.model.dto.UpdateStockDTO;
import com.getir.bookstore.core.order.model.domain.BookStock;

public interface UpdateStockUseCase extends BaseUseCase<UpdateStockDTO, BookStock> {
}
