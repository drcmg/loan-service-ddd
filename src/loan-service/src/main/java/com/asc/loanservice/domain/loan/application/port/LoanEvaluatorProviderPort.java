package com.asc.loanservice.domain.loan.application.port;

import com.asc.loanservice.domain.loan.application.contract.LoanApplicationRequest;


public interface LoanEvaluatorProviderPort {

    LoanEvaluationResult evaluate(LoanApplicationRequest loanApplicationRequest);
}
