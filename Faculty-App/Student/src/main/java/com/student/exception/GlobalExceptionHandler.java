package com.student.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(DuplicateStudentException.class)
    public ResponseEntity<String> handleDuplicateEception(DuplicateStudentException d) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(d.getMessage());
    }

    public ResponseEntity<String> handledBOperation(DatabaseOperationException d){
        return  ResponseEntity.status(HttpStatus.CONFLICT).body(d.getMessage());
    }


}
