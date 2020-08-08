package com.asc.loanservice.infrastructure.exception;


import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class ExceptionFormat {

    private String message;
    private String description;
}