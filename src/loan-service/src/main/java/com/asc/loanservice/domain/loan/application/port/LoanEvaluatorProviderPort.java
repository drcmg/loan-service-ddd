package com.asc.loanservice.domain.loan.application.port;

import com.asc.loanservice.contracts.LoanApplicationRequest;

public interface LoanEvaluatorProviderPort {
    LoanEvaluationStatus evaluate(LoanApplicationRequest loanApplicationRequest);
}
