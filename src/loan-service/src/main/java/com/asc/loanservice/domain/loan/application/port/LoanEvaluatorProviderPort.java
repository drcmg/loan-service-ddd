package com.asc.loanservice.domain.loan.application.port;

import com.asc.loanservice.infrastructure.api.contracts.LoanApplicationRequest;
import com.asc.loanservice.infrastructure.LoanEvaluationResult;

public interface LoanEvaluatorProviderPort {
    LoanEvaluationResult evaluate(LoanApplicationRequest loanApplicationRequest);
}
