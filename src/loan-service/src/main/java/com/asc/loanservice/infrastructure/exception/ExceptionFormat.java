package com.asc.loanservice.infrastructure.exception;

import lombok.*;


@Builder
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionFormat {
    private String message;
    private String description;
}