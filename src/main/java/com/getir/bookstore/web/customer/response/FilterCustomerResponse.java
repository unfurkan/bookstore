package com.getir.bookstore.web.customer.response;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class FilterCustomerResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String cellPhone;

    private String email;

}
