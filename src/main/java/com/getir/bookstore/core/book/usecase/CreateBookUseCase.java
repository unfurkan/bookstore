package com.getir.bookstore.core.book.usecase;

import com.getir.bookstore.common.usecase.BaseUseCase;
import com.getir.bookstore.core.book.model.domain.Book;
import com.getir.bookstore.core.book.model.dto.CreateBookDTO;

public interface CreateBookUseCase extends BaseUseCase<CreateBookDTO, Book> {
}
