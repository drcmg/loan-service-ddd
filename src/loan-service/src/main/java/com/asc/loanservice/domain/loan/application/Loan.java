package com.asc.loanservice.domain.loan.application;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;


@Builder
class Loan {

    private BigDecimal loanAmount;
    private Integer numberOfInstallments;
    private LocalDate firstInstallmentDate;
}
