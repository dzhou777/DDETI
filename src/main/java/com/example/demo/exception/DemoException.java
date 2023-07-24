package com.example.demo.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class DemoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private HttpStatus statusCode;

    public DemoException(String message, HttpStatus statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
