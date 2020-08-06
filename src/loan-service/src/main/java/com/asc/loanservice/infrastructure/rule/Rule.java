package com.asc.loanservice.infrastructure.rule;

import com.asc.loanservice.contracts.LoanApplicationRequest;

public interface Rule {
    Boolean isValid(LoanApplicationRequest loanApplicationRequest);
}
