package com.getir.bookstore.common.exception.handler;


import com.getir.bookstore.common.response.ApplicationMessageResponse;
import com.getir.bookstore.common.response.ApplicationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BaseExceptionHandler {

    public static final String APPLICATION_VALIDATION_ERROR = "APP-VALIDATION-ERR";
    public static final String ERROR_MESSAGE = "error.message";


    public ApplicationResponse createApplicationResponse(List<ApplicationMessageResponse> messages) {
        return ApplicationResponse.builder()
                .success(false)
                .messages(messages)
                .build();
    }

    public ApplicationResponse createApplicationResponse(List<FieldError> fieldErrors, ApplicationMessageResponse applicationMessageResponse, MessageSource messageSource) {
        return ApplicationResponse.builder()
                .mainMessage(applicationMessageResponse)
                .success(false)
                .messages(getErrorMessages(fieldErrors, messageSource))
                .build();
    }

    private List<ApplicationMessageResponse> getErrorMessages(List<FieldError> fieldErrors, MessageSource messageSource) {
        return Optional.ofNullable(fieldErrors)
                .orElse(Collections.emptyList())
                .stream()
                .map(fieldError -> createApplicationMessageResponse(messageSource, fieldError.getDefaultMessage()))
                .collect(Collectors.toList());
    }

    public ApplicationMessageResponse createApplicationMessageResponse(MessageSource messageSource, String message) {

        ApplicationMessageResponse applicationMessageResponse = new ApplicationMessageResponse();
        applicationMessageResponse.setMessageTypeCode(APPLICATION_VALIDATION_ERROR);
        setMessage(messageSource, message, applicationMessageResponse, null);

        return applicationMessageResponse;
    }


    private static void setMessage(MessageSource messageSource, String message, ApplicationMessageResponse applicationMessageResponse, String param) {
        try {
            String localisedMessage = messageSource.getMessage(message, Objects.isNull(param) ? null : new String[]{param}, LocaleContextHolder.getLocale());
            applicationMessageResponse.setMessage(localisedMessage);
        } catch (Exception exception) {
            applicationMessageResponse.setMessage(messageSource.getMessage(ERROR_MESSAGE, null, LocaleContextHolder.getLocale()));
        }
    }

}
