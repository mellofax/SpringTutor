package com.example.springtutor.exception;

import com.example.springtutor.controller.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ControllerException.class)
    public ResponseEntity<Object> handleControllerException(
            ControllerException ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
