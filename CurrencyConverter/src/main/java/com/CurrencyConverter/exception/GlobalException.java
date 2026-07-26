package com.CurrencyConverter.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleBalance(DataIntegrityViolationException ex) {
        System.out.println("DataIntegerity called");
        return ResponseEntity.badRequest().body(ex.getMessage());
    }



}
