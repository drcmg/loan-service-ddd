package com.asc.loanservice.domain.loan.application;

import com.asc.loanservice.domain.loan.application.dto.LoanApplicationRequest;


public interface LoanEvaluatorProviderPort {

    LoanEvaluationResult evaluate(LoanApplicationRequest loanApplicationRequest, String loanApplicationNumber);
    LoanEvaluationResult getLoanApplicationEvaluationResult(String loanApplicationNumber);
}
