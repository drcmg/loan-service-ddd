package com.asc.loanservice.exception;


import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
class ExceptionFormat {

    private String message;
    private String description;
}