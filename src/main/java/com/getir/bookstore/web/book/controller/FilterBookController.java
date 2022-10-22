package com.getir.bookstore.web.book.controller;

import com.getir.bookstore.common.pageable.request.Pageable;
import com.getir.bookstore.common.pageable.response.PageableResponse;
import com.getir.bookstore.common.response.ApplicationResponse;
import com.getir.bookstore.core.book.model.domain.Book;
import com.getir.bookstore.core.book.model.dto.FilterBookDTO;
import com.getir.bookstore.core.book.service.BookService;
import com.getir.bookstore.web.book.mapper.FilterBookRequestMapper;
import com.getir.bookstore.web.book.mapper.FilterBookResponseMapper;
import com.getir.bookstore.web.book.request.FilterBookRequest;
import com.getir.bookstore.web.book.response.FilterBookResponse;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/v1/books")
@RestController
public class FilterBookController {

    private final FilterBookRequestMapper filterBookRequestMapper;
    private final FilterBookResponseMapper filterBookResponseMapper;
    private final BookService bookService;

    public FilterBookController(FilterBookRequestMapper filterBookRequestMapper, FilterBookResponseMapper filterBookResponseMapper, BookService bookService) {
        this.filterBookRequestMapper = filterBookRequestMapper;
        this.filterBookResponseMapper = filterBookResponseMapper;
        this.bookService = bookService;
    }

    @PostMapping("/filter")
    public ApplicationResponse filterBooks(@Valid @RequestBody Pageable<FilterBookRequest> filterBookRequestPageable) {

        Pageable<FilterBookDTO> filterBookDTOPageable = filterBookRequestMapper.toDTO(filterBookRequestPageable);

        Page<Book> pageBook = bookService.filterPaging(filterBookDTOPageable);

        List<FilterBookResponse> filterBookResponses = filterBookResponseMapper.toListResponse(pageBook.getContent());

        return ApplicationResponse.builder()
                .success(true)
                .content(getPageableResponse(filterBookResponses, pageBook))
                .build();
    }

    public PageableResponse getPageableResponse(List<FilterBookResponse> responses, Page<Book> bookPage) {
        PageableResponse pageableResponse = new PageableResponse<>();
        pageableResponse.setList(responses);
        pageableResponse.setTotalElements(bookPage.getTotalElements());
        pageableResponse.setTotalPages(bookPage.getTotalPages());
        pageableResponse.setPageNumber(bookPage.getPageable().getPageNumber() + 1);
        pageableResponse.setPageSize(bookPage.getPageable().getPageSize());
        return pageableResponse;
    }

}
