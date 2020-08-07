package com.asc.loanservice.domain.loan.rule;

import com.asc.loanservice.infrastructure.api.contract.LoanApplicationRequest;

public class CustomerAgeRule implements Rule {

    @Override
    public Boolean isValid(LoanApplicationRequest loanApplicationRequest) {
        return true;
    }
}
