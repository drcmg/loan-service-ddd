package com.asc.loanservice.domain.loan.application;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanApplicationAggregate {

    private Customer customer;
    private Loan loan;
    private EvaluationStatus evaluationStatus;
    private LocalDateTime createdDate;

}
