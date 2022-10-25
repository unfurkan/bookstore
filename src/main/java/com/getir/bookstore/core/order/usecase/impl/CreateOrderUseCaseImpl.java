package com.getir.bookstore.core.order.usecase.impl;

import com.getir.bookstore.common.exception.RequestNotValidException;
import com.getir.bookstore.common.response.ApplicationMessageResponse;
import com.getir.bookstore.core.book.model.domain.Book;
import com.getir.bookstore.core.book.service.BookService;
import com.getir.bookstore.core.customer.model.domain.Customer;
import com.getir.bookstore.core.customer.service.CustomerService;
import com.getir.bookstore.core.order.model.domain.BookStock;
import com.getir.bookstore.core.order.model.domain.Order;
import com.getir.bookstore.core.order.model.domain.OrderItem;
import com.getir.bookstore.core.order.model.dto.CreateOrderDTO;
import com.getir.bookstore.core.order.model.dto.CreateOrderItemDTO;
import com.getir.bookstore.core.order.service.OrderItemService;
import com.getir.bookstore.core.order.service.OrderService;
import com.getir.bookstore.core.order.usecase.CreateOrderUseCase;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

    public static final String ORD_PREFIX = "ORD";
    public static final String STOCK_NOT_AVAILABLE = "stock.not.available";

    private final OrderService orderService;
    private final BookService bookService;
    private final CustomerService customerService;
    private final OrderItemService orderItemService;
    private final MessageSource messageSource;

    public CreateOrderUseCaseImpl(OrderService orderService, BookService bookService, CustomerService customerService, OrderItemService orderItemService, MessageSource messageSource) {
        this.orderService = orderService;
        this.bookService = bookService;
        this.customerService = customerService;
        this.orderItemService = orderItemService;
        this.messageSource = messageSource;
    }


    @Override
    @Transactional
    public Order exec(CreateOrderDTO createOrderDTO) {

        Order order = new Order();
        order.setNote(createOrderDTO.getNote());
        order.setDeliveryAddress(createOrderDTO.getDeliveryAddress());
        order.setInvoiceAddress(createOrderDTO.getInvoiceAddress());
        order.setCode(ORD_PREFIX + new Date().getTime());

        order.setCustomer(getCustomer(createOrderDTO.getCustomerId()));
        order.setOrderItems(getOrderItems(createOrderDTO.getOrderItems(), order));

        order.setTotalPrice(calculateTotalPrice(order.getOrderItems()));

        return orderService.save(order);
    }

    private List<OrderItem> getOrderItems(List<CreateOrderItemDTO> createOrderItemDTOS, Order order) {
        List<OrderItem> orderItems = createOrderItemDTOS.stream()
                .map(createOrderItemDTO -> createOrderItem(createOrderItemDTO, order))
                .collect(Collectors.toList());

        return orderItemService.saveAll(orderItems);
    }

    private BigDecimal calculateTotalPrice(List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(createOrderItemDTO -> getOrderItemPrice(createOrderItemDTO))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal getOrderItemPrice(OrderItem orderItem) {
        return BigDecimal.valueOf(orderItem.getQuantity()).multiply(orderItem.getBook().getUnitPrice());
    }

    private OrderItem createOrderItem(CreateOrderItemDTO createOrderItemDTO, Order order) {

        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setQuantity(createOrderItemDTO.getQuantity());

        Book book = getBook(createOrderItemDTO.getBookId());
        orderItem.setBook(book);
        orderItem.setUnitPrice(book.getUnitPrice());

        updateStock(createOrderItemDTO, book);

        return orderItem;
    }

    private void updateStock(CreateOrderItemDTO createOrderItemDTO, Book book) {

        Integer remainingStock = book.getStock().getStockAmount() - createOrderItemDTO.getQuantity();

        if (remainingStock < 0) {
            throw new RequestNotValidException(List.of(setResponseWithArgs(STOCK_NOT_AVAILABLE, Stream.of(book.getTitle()).toArray())));
        }

        book.getStock().setStockAmount(remainingStock);

    }

    private Customer getCustomer(Long customerId) {
        return customerService.getById(customerId);
    }

    private Book getBook(Long bookId) {
        return bookService.getById(bookId);
    }


    public ApplicationMessageResponse setResponseWithArgs(String message, Object[] args) {
        return getApplicationMessageResponse(messageSource.getMessage(message, args, LocaleContextHolder.getLocale()));
    }

    private ApplicationMessageResponse getApplicationMessageResponse(String message) {
        ApplicationMessageResponse applicationMessageResponse = new ApplicationMessageResponse();
        applicationMessageResponse.setMessage(message);
        return applicationMessageResponse;
    }
}
