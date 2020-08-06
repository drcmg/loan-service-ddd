package com.asc.loanservice.infrastructure.rule;

import com.asc.loanservice.contracts.LoanApplicationRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerAgeRule implements Rule {

    @Override
    public Boolean isValid(LoanApplicationRequest loanApplicationRequest) {
        return true;
    }
}
