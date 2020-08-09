package com.asc.loanservice.domain.loan.application.dto;


import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class LoanApplicationResult {

    private final String loanRequestNumber;
    private final LoanApplicationEvaluationStatus evaluationResult;
}
