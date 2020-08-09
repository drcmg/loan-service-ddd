package com.asc.loanservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;


@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionFormat> constraintViolationException(ConstraintViolationException ex){
        String description = ex.getConstraintViolations().stream()
                .findFirst()
                .map(e -> String.format("%s value '%s' %s", getPropertyNameFromConstraint(e),
                        e.getInvalidValue(), e.getMessage()))
                .orElse("Unknown exception");

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ExceptionFormat.builder()
                        .message("Your request is not valid.")
                        .description(description)
                        .build());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionFormat> entityNotFoundException(EntityNotFoundException ex){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ExceptionFormat.builder()
                        .message("Entity was not found.")
                        .description("Loan request not found in database.")
                        .build());
    }

    private String getPropertyNameFromConstraint(ConstraintViolation<?> e) {
        String[] split = e.getPropertyPath().toString().split("\\.");
        return split[split.length-1];
    }
}
