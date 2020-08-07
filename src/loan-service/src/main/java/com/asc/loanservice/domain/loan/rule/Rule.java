package com.asc.loanservice.domain.loan.rule;

import com.asc.loanservice.infrastructure.api.contracts.LoanApplicationRequest;

public interface Rule {
    Boolean isValid(LoanApplicationRequest loanApplicationRequest);
}
