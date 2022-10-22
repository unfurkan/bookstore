package com.getir.bookstore.core.customer.validation;

import com.getir.bookstore.common.exception.RequestNotValidException;
import com.getir.bookstore.common.response.ApplicationMessageResponse;
import com.getir.bookstore.common.validation.BaseValidation;
import com.getir.bookstore.common.validation.CustomBaseValidator;
import com.getir.bookstore.core.customer.model.dto.CreateCustomerDTO;
import com.getir.bookstore.core.customer.service.CustomerService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateCustomerValidation extends BaseValidation implements CustomBaseValidator<CreateCustomerDTO> {

    public static final String EMAIL_ALREADY_EXIST = "email.already.exist";
    public static final String CELL_PHONE_ALREADY_EXIST = "cellphone.already.exist";

    private final CustomerService customerService;


    public CreateCustomerValidation(MessageSource messageSource, CustomerService customerService) {
        super(messageSource);
        this.customerService = customerService;
    }

    @Override
    public List<ApplicationMessageResponse> validate(CreateCustomerDTO createCustomerDTO) {

        List<ApplicationMessageResponse> errors = new ArrayList<>();

        if (customerService.existsByEmail(createCustomerDTO.getEmail())) {
            errors.add(setResponse(EMAIL_ALREADY_EXIST));
        }

        if (customerService.existsByCellPhone(createCustomerDTO.getCellPhone())) {
            errors.add(setResponse(CELL_PHONE_ALREADY_EXIST));
        }

        if (!CollectionUtils.isEmpty(errors)) {
            throw new RequestNotValidException(errors);
        }

        return errors;
    }
}
