package com.aqadoos.demo.service.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class PersonResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception e, WebRequest request) {
        PersonExceptionResponse personExceptionResponse =
                new PersonExceptionResponse(new Date(), e.getMessage(), request.getDescription(false));
        ResponseEntity<Object> responseEntity =
                new ResponseEntity<Object>(personExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<Object> handlePersonNotFoundException(Exception e, WebRequest request) {
        PersonExceptionResponse personExceptionResponse =
                new PersonExceptionResponse(new Date(), e.getMessage(), request.getDescription(false));
        ResponseEntity<Object> responseEntity =
                new ResponseEntity<Object>(personExceptionResponse, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        PersonExceptionResponse personExceptionResponse =
                new PersonExceptionResponse(
                        new Date(),
                        StringUtils.collectionToCommaDelimitedString(ex.getBindingResult().getAllErrors()),
                        ex.getMessage());
        ResponseEntity<Object> responseEntity =
                new ResponseEntity<>(personExceptionResponse, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }
}
