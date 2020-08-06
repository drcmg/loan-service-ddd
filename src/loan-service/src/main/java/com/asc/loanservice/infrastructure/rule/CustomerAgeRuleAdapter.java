package com.asc.loanservice.infrastructure.rule;

import com.asc.loanservice.contracts.LoanApplicationRequest;
import com.asc.loanservice.domain.loan.evaluation.port.RulePort;
import org.springframework.stereotype.Service;

@Service
public class CustomerAgeRuleAdapter implements RulePort {

    @Override
    public Boolean isValid(LoanApplicationRequest loanApplicationRequest) {
        return true;
    }
}
