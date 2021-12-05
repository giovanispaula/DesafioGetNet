package com.getnet.UserGetNet.error;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class CustomError extends RuntimeException{
    public CustomError(String message) {
        super(message);
    }
}


