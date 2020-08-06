package com.asc.loanservice.domain.loan.evaluation.rules;


import com.asc.loanservice.contracts.LoanApplicationRequest;
import com.asc.loanservice.domain.loan.evaluation.Rule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class NotExistInDeptRegisterRule implements Rule {

    @Override
    public Boolean isValid(LoanApplicationRequest loanApplicationRequest) {
        return true;
    }
}
