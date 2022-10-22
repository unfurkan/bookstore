package com.getir.bookstore.web.customer.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateCustomerRequest {

    @NotBlank(message = "not.blank.customer.first.name")
    private String firstName;

    @NotBlank(message = "not.blank.customer.last.name")
    private String lastName;

    @NotBlank(message = "not.blank.customer.cellPhone")
    private String cellPhone;

    @NotBlank(message = "not.blank.customer.email")
    @Email(message = "email.not.valid")
    private String email;

    @NotBlank(message = "not.blank.customer.password")
    private String password;

}
