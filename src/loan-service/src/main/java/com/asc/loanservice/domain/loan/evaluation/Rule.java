package com.asc.loanservice.domain.loan.evaluation;

import com.asc.loanservice.domain.loan.application.contract.LoanApplicationRequest;


public interface Rule {

    Boolean isValid(LoanApplicationRequest loanApplicationRequest);
}
