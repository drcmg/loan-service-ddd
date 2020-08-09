package com.asc.loanservice.domain.loan.evaluation.south;

import lombok.Getter;


@Getter
public class CustomerCheckResultDto {

    private String customerTaxId;
    private Boolean isRegisteredDebtor;
}
