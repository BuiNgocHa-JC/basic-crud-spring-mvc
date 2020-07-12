package com.luv2code.springdemo.exception;

import com.luv2code.springdemo.rest.CustomerErrResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

    // Add an exception handle for CustomerNotFoundException
    @ExceptionHandler
    public ResponseEntity<CustomerErrResponse> handleException(CustomerNotFoundException exc) {
        CustomerErrResponse error = new CustomerErrResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<CustomerErrResponse>(error, HttpStatus.NOT_FOUND);
    }

    // Add an exception to catch String not found exception
    @ExceptionHandler
    public ResponseEntity<CustomerErrResponse> handleException(Exception exc) {
        CustomerErrResponse error = new CustomerErrResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<CustomerErrResponse>(error, HttpStatus.BAD_REQUEST);
    }
}
