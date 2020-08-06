package com.asc.loanservice.domain.loan.evaluation;

import com.asc.loanservice.contracts.LoanApplicationRequest;

public interface Rule {

    Boolean isValid(LoanApplicationRequest loanApplicationRequest);
}
