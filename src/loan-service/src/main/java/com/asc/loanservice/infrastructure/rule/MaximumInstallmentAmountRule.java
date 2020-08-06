package com.asc.loanservice.infrastructure.rule;

import com.asc.loanservice.contracts.LoanApplicationRequest;
import com.asc.loanservice.domain.loan.application.port.RulePort;
import org.springframework.stereotype.Service;

@Service
public class MaximumInstallmentAmountRuleAdapter implements RulePort {

    @Override
    public Boolean isValid(LoanApplicationRequest loanApplicationRequest) {
        return true;
    }
}
