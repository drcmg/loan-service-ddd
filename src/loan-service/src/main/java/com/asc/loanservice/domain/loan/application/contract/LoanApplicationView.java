package com.asc.loanservice.domain.loan.application.contract;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Builder
public class LoanApplicationView {

    private String loanRequestNumber;
    private String customerName;
    private LocalDate customerBirthday;
    private String customerTaxId;
    private BigDecimal customerMonthlyIncome;
    private BigDecimal loanAmount;
    private Integer numberOfInstallments;
    private LocalDate firstInstallmentDate;
    private LoanApplicationEvaluationStatus evaluationResult;
    private LocalDateTime registrationDate;
}
