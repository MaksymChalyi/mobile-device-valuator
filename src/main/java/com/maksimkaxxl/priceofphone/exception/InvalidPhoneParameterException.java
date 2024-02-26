package com.maksimkaxxl.priceofphone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidPhoneParameterException extends RuntimeException {

    public InvalidPhoneParameterException(String message) {
        super(message);
    }
}
