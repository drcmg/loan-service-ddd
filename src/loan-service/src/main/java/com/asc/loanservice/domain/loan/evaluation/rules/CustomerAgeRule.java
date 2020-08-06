package com.asc.loanservice.domain.loan.evaluation.rules;

import com.asc.loanservice.contracts.LoanApplicationRequest;
import com.asc.loanservice.domain.loan.evaluation.Rule;
import org.springframework.stereotype.Service;

@Service
public class CustomerAgeRule implements Rule {

    @Override
    public Boolean isValid(LoanApplicationRequest loanApplicationRequest) {
        return true;
    }
}
