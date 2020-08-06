package com.asc.loanservice.domain.loan.application;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
class Loan {

    private final BigDecimal loanAmount;
    private final Integer numberOfInstallments;
    private final LocalDate firstInstallmentDate;
}
