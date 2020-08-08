package com.asc.loanservice.external;

import lombok.Getter;


@Getter
public class CustomerCheckResultDto {

    private String customerTaxId;
    private Boolean isRegisteredDebtor;
}
