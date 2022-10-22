package com.getir.bookstore.common.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ApplicationResponse {

    private boolean success;

    private Object content;

    private ApplicationMessageResponse mainMessage;

    private List<ApplicationMessageResponse> messages;

}

