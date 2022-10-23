package com.getir.bookstore.core.order.model.domain;

import com.getir.bookstore.core.book.model.domain.Book;
import com.getir.bookstore.core.common.BaseEntity;
import com.getir.bookstore.core.customer.model.domain.Customer;
import com.getir.bookstore.core.order.model.enums.Month;
import com.getir.bookstore.core.order.model.enums.converter.MonthEnumConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Table(name = "ORDERS")
@Entity
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CODE", unique = true)
    private String code;

    @Column(name = "NOTE")
    private String note;

    @Convert(converter = MonthEnumConverter.class)
    @Column(name = "ORDER_MONTH")
    private Month month;

    @Column(name = "TOTAL_PRICE")
    private BigDecimal totalPrice;

    @Column(name = "DELIVERY_ADDRESS")
    private String deliveryAddress;

    @Column(name = "INVOICE_ADDRESS")
    private String invoiceAddress;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

}
