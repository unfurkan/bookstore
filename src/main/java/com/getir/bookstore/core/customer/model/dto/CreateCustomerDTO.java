package com.getir.bookstore.core.customer.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerDTO {

    private String firstName;

    private String lastName;

    private String cellPhone;

    private String email;

    private String password;

}
