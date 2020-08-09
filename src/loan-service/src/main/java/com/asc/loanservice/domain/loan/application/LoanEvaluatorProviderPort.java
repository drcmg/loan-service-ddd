package com.asc.loanservice.domain.loan.application;

import com.asc.loanservice.domain.loan.application.contract.LoanApplicationRequest;


public interface LoanEvaluatorProviderPort {

    LoanEvaluationResult evaluate(LoanApplicationRequest loanApplicationRequest, String loanApplicationNumber);
    LoanEvaluationResult getLoanApplicationEvaluationResult(String loanApplicationNumber);
}