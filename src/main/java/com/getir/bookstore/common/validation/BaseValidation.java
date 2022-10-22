package com.getir.bookstore.common.validation;

import com.getir.bookstore.common.response.ApplicationMessageResponse;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

public class BaseValidation {

    private final MessageSource messageSource;
    public static final String APPLICATION_VALIDATION_ERROR = "APP-VALIDATION-ERR";

    public BaseValidation(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public ApplicationMessageResponse setResponse(String message) {
        String localisedMessage = messageSource.getMessage(message, null, LocaleContextHolder.getLocale());
        return getApplicationMessageResponse(localisedMessage);
    }

    private ApplicationMessageResponse getApplicationMessageResponse(String message) {
        ApplicationMessageResponse applicationMessageResponse = new ApplicationMessageResponse();
        applicationMessageResponse.setMessageTypeCode(APPLICATION_VALIDATION_ERROR);
        applicationMessageResponse.setMessage(message);
        return applicationMessageResponse;
    }

}
