package com.asc.loanservice.domain.loan.application.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Builder
public class LoanApplicationView {

    private final String loanRequestNumber;
    private final String customerName;
    private final LocalDate customerBirthday;
    private final String customerTaxId;
    private final BigDecimal customerMonthlyIncome;
    private final BigDecimal loanAmount;
    private final Integer numberOfInstallments;
    private final LocalDate firstInstallmentDate;
    private final LoanApplicationEvaluationStatus evaluationResult;
    private final LocalDateTime registrationDate;
}
