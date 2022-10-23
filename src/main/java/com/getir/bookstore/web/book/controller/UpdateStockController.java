package com.getir.bookstore.web.book.controller;

import com.getir.bookstore.common.response.ApplicationResponse;
import com.getir.bookstore.core.book.model.domain.Book;
import com.getir.bookstore.core.book.model.dto.UpdateStockDTO;
import com.getir.bookstore.core.book.usecase.UpdateStockUseCase;
import com.getir.bookstore.web.book.mapper.UpdateStockRequestMapper;
import com.getir.bookstore.web.book.request.UpdateStockRequest;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/v1/books")
@RestController
public class UpdateStockController {

    private final UpdateStockUseCase updateStockUseCase;
    private final UpdateStockRequestMapper updateStockRequestMapper;

    public UpdateStockController(UpdateStockUseCase updateStockUseCase, UpdateStockRequestMapper updateStockRequestMapper) {
        this.updateStockUseCase = updateStockUseCase;
        this.updateStockRequestMapper = updateStockRequestMapper;
    }


    @PutMapping("/update-stock")
    ApplicationResponse updateStock(@Valid @RequestBody UpdateStockRequest updateStockRequest) {

        UpdateStockDTO updateStockDTO = updateStockRequestMapper.toDTO(updateStockRequest);

        updateStockUseCase.exec(updateStockDTO);

        return ApplicationResponse.builder()
                .success(true)
                .build();
    }


}
