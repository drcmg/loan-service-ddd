package com.asc.loanservice.domain.loan.evaluation.port;

import com.asc.loanservice.contracts.LoanApplicationRequest;

public interface RulePort {

    Boolean isValid(LoanApplicationRequest loanApplicationRequest);
}
