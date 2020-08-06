package com.asc.loanservice.infrastructure.rule;


import com.asc.loanservice.contracts.LoanApplicationRequest;
import com.asc.loanservice.domain.loan.evaluation.port.RulePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class NotExistInDeptRegisterRuleAdapter implements RulePort {

    @Override
    public Boolean isValid(LoanApplicationRequest loanApplicationRequest) {
        return true;
    }
}
