package com.getir.bookstore.core.order.usecase.impl;

import com.getir.bookstore.core.book.model.domain.Book;
import com.getir.bookstore.core.book.model.dto.UpdateStockDTO;
import com.getir.bookstore.core.book.service.BookService;
import com.getir.bookstore.core.book.usecase.UpdateStockUseCase;
import com.getir.bookstore.core.customer.model.domain.Customer;
import com.getir.bookstore.core.customer.service.CustomerService;
import com.getir.bookstore.core.order.model.domain.BookStock;
import com.getir.bookstore.core.order.model.domain.Order;
import com.getir.bookstore.core.order.model.domain.OrderItem;
import com.getir.bookstore.core.order.model.dto.CreateOrderDTO;
import com.getir.bookstore.core.order.model.dto.CreateOrderItemDTO;
import com.getir.bookstore.core.order.service.BookStockService;
import com.getir.bookstore.core.order.service.OrderItemService;
import com.getir.bookstore.core.order.service.OrderService;
import com.getir.bookstore.core.order.usecase.CreateOrderUseCase;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

    public static final String ORD_PREFIX = "ORD";
    public static final String STOCK_NOT_AVAILABLE = "stock.not.available";

    private final OrderService orderService;
    private final BookService bookService;
    private final CustomerService customerService;
    private final OrderItemService orderItemService;

    public CreateOrderUseCaseImpl(OrderService orderService, BookService bookService, CustomerService customerService, OrderItemService orderItemService) {
        this.orderService = orderService;
        this.bookService = bookService;
        this.customerService = customerService;
        this.orderItemService = orderItemService;
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

        updateStock(createOrderItemDTO, book.getStock());

        return orderItem;
    }

    private void updateStock(CreateOrderItemDTO createOrderItemDTO, BookStock stock) {

        Integer remainingStock = stock.getStockAmount() - createOrderItemDTO.getQuantity();

        if (remainingStock < 0) {
            throw new RuntimeException(STOCK_NOT_AVAILABLE);
        }

        stock.setStockAmount(remainingStock);

    }

    private Customer getCustomer(Long customerId) {
        return customerService.getById(customerId);
    }

    private Book getBook(Long bookId) {
        return bookService.getById(bookId);
    }

}
