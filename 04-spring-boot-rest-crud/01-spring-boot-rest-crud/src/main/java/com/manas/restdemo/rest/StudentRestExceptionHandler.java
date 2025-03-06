package com.manas.restdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
    // add exception handling code here

    // add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {
        // create s StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus((HttpStatus.NOT_FOUND.value()));
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResonseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {
        // create s StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus((HttpStatus.BAD_REQUEST.value()));
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResonseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
