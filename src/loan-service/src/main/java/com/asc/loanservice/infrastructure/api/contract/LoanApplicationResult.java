package com.asc.loanservice.infrastructure.api.contract;


import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class LoanApplicationResult {

    private String loanRequestNumber;
    private LoanApplicationEvaluationStatus evaluationResult;
}
