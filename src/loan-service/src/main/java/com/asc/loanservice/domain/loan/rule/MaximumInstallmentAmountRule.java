package com.asc.loanservice.domain.loan.rule;

import com.asc.loanservice.infrastructure.api.contracts.LoanApplicationRequest;

public class MaximumInstallmentAmountRule implements Rule {

    @Override
    public Boolean isValid(LoanApplicationRequest loanApplicationRequest) {
        return true;
    }
}
