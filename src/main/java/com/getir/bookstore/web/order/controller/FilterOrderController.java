package com.getir.bookstore.web.order.controller;

import com.getir.bookstore.common.pageable.request.Pageable;
import com.getir.bookstore.common.pageable.response.PageableResponse;
import com.getir.bookstore.common.response.ApplicationResponse;
import com.getir.bookstore.common.utils.PagingUtils;
import com.getir.bookstore.core.book.model.domain.Book;
import com.getir.bookstore.core.book.model.dto.FilterBookDTO;
import com.getir.bookstore.core.order.model.domain.Order;
import com.getir.bookstore.core.order.model.dto.FilterOrderDTO;
import com.getir.bookstore.core.order.service.OrderService;
import com.getir.bookstore.web.book.response.FilterBookResponse;
import com.getir.bookstore.web.order.mapper.FilterOrderRequestMapper;
import com.getir.bookstore.web.order.mapper.FilterOrderResponseMapper;
import com.getir.bookstore.web.order.request.FilterOrderRequest;
import com.getir.bookstore.web.order.response.FilterOrderResponse;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/v1/orders")
@RestController
public class FilterOrderController {

    private final FilterOrderRequestMapper filterOrderRequestMapper;
    private final FilterOrderResponseMapper filterOrderResponseMapper;
    private final OrderService orderService;

    public FilterOrderController(FilterOrderRequestMapper filterOrderRequestMapper, FilterOrderResponseMapper filterOrderResponseMapper, OrderService orderService) {
        this.filterOrderRequestMapper = filterOrderRequestMapper;
        this.filterOrderResponseMapper = filterOrderResponseMapper;
        this.orderService = orderService;
    }


    @PostMapping("/filter")
    public ApplicationResponse filterOrders(@Valid @RequestBody Pageable<FilterOrderRequest> filterOrderRequestPageable) {

        Pageable<FilterOrderDTO> filterOrderDTOPageable = filterOrderRequestMapper.toDTO(filterOrderRequestPageable);

        Page<Order> pageOrder = orderService.filterPaging(filterOrderDTOPageable);

        List<FilterOrderResponse> filterOrderResponses = filterOrderResponseMapper.toListResponse(pageOrder.getContent());

        return ApplicationResponse.builder()
                .success(true)
                .content(PagingUtils.getPageableResponse(filterOrderResponses, pageOrder))
                .build();
    }

}
