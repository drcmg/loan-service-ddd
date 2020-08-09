package com.asc.loanservice.domain.loan.application.north.exception;


import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
class ExceptionFormat {

    private final String message;
    private final String description;
}