package com.getir.bookstore.web.book.controller;

import com.getir.bookstore.common.response.ApplicationResponse;
import com.getir.bookstore.core.book.model.domain.Book;
import com.getir.bookstore.core.book.model.dto.CreateBookDTO;
import com.getir.bookstore.core.book.usecase.CreateBookUseCase;
import com.getir.bookstore.web.book.mapper.CreateBookRequestMapper;
import com.getir.bookstore.web.book.mapper.CreateBookResponseMapper;
import com.getir.bookstore.web.book.request.CreateBookRequest;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/v1/books")
@RestController
public class CreateBookController {

    private final CreateBookRequestMapper createBookRequestMapper;
    private final CreateBookResponseMapper createBookResponseMapper;
    private final CreateBookUseCase createBookUseCase;

    public CreateBookController(CreateBookRequestMapper createBookRequestMapper, CreateBookResponseMapper createBookResponseMapper, CreateBookUseCase createBookUseCase) {
        this.createBookRequestMapper = createBookRequestMapper;
        this.createBookResponseMapper = createBookResponseMapper;
        this.createBookUseCase = createBookUseCase;
    }


    @PostMapping
    public ApplicationResponse createBook(@Valid @RequestBody CreateBookRequest createBookRequest) {

        CreateBookDTO createBookDTO = createBookRequestMapper.toDTO(createBookRequest);

        Book book = createBookUseCase.exec(createBookDTO);

        return ApplicationResponse.builder()
                .success(true)
                .content(createBookResponseMapper.toResponse(book))
                .build();
    }
}
