package com.asc.loanservice.domain.loan.application.port;

import com.asc.loanservice.infrastructure.LoanEvaluationResult;
import com.asc.loanservice.infrastructure.api.contract.LoanApplicationRequest;


public interface LoanEvaluatorProviderPort {

    LoanEvaluationResult evaluate(LoanApplicationRequest loanApplicationRequest);
}
