package com.getir.bookstore.core.customer.model.domain;

import com.getir.bookstore.core.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMERS")
@Getter
@Setter
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "CELL_PHONE", unique = true)
    private String cellPhone;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

}
