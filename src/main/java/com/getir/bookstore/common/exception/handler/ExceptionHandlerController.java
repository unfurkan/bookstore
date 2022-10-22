package com.getir.bookstore.common.exception.handler;
import com.getir.bookstore.common.exception.RequestNotValidException;
import com.getir.bookstore.common.response.ApplicationMessageResponse;
import com.getir.bookstore.common.response.ApplicationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerController extends BaseExceptionHandler {

    private final MessageSource messageSource;

    private static final String REQUEST_BODY_NOT_VALID = "request.body.not.valid";


    public ExceptionHandlerController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ApplicationResponse methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        exception.printStackTrace();
        ApplicationMessageResponse applicationMessageResponse = createApplicationMessageResponse(messageSource, REQUEST_BODY_NOT_VALID);
        return createApplicationResponse(exception.getFieldErrors(), applicationMessageResponse, messageSource);
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ApplicationResponse noSuchElementExceptionHandler(NoSuchElementException exception) {
        exception.printStackTrace();
        ApplicationMessageResponse applicationMessageResponse = createApplicationMessageResponse(messageSource, exception.getMessage());
        return createApplicationResponse(null, applicationMessageResponse, messageSource);
    }

    @ExceptionHandler(RequestNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ApplicationResponse requestNotValidExceptionHandler(RequestNotValidException exception) {
        exception.printStackTrace();
        return createApplicationResponse(exception.getFieldList());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ApplicationResponse onException(Exception exception) {
        exception.printStackTrace();
        return createApplicationResponse(List.of(createApplicationMessageResponse(messageSource, exception.getMessage())));
    }

}
