package com.getir.bookstore.web.security.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TokenRequest {

    @NotBlank(message = "not.null.token.username")
    private String username;

    @NotBlank(message = "not.null.token.password")
    private String password;

}
