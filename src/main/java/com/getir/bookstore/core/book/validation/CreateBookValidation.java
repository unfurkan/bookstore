package com.getir.bookstore.core.book.validation;

import com.getir.bookstore.common.exception.RequestNotValidException;
import com.getir.bookstore.common.response.ApplicationMessageResponse;
import com.getir.bookstore.common.validation.BaseValidation;
import com.getir.bookstore.common.validation.CustomBaseValidator;
import com.getir.bookstore.core.book.model.dto.CreateBookDTO;
import com.getir.bookstore.core.book.service.BookService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateBookValidation extends BaseValidation implements CustomBaseValidator<CreateBookDTO> {

    public static final String ISBN_ALREADY_EXIST = "isbn.already.exist";

    private final BookService bookService;

    public CreateBookValidation(MessageSource messageSource, BookService bookService) {
        super(messageSource);
        this.bookService = bookService;
    }


    @Override
    public List<ApplicationMessageResponse> validate(CreateBookDTO createBookDTO) {

        List<ApplicationMessageResponse> errors = new ArrayList<>();

        if (bookService.existsByIsbn(createBookDTO.getIsbn())) {
            errors.add(setResponse(ISBN_ALREADY_EXIST));
        }

        if (!CollectionUtils.isEmpty(errors)) {
            throw new RequestNotValidException(errors);
        }

        return errors;
    }
}
