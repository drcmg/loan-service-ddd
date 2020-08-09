package com.asc.loanservice.domain.loan.application.contract;


import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class LoanApplicationResult {

    private String loanRequestNumber;
    private LoanApplicationEvaluationStatus evaluationResult;
}
