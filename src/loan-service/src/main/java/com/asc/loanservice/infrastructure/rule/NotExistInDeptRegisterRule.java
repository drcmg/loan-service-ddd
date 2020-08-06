package com.asc.loanservice.infrastructure.rule;


import com.asc.loanservice.contracts.LoanApplicationRequest;
import com.asc.loanservice.domain.loan.application.port.DebtPort;
import com.asc.loanservice.domain.loan.application.port.RulePort;
import com.asc.loanservice.external.DebtCustomerResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class NotExistInDeptRegisterRuleAdapter implements RulePort {

    private final DebtPort debtPort;

    @Override
    public Boolean isValid(LoanApplicationRequest loanApplicationRequest) {
        return debtPort.checkDebtClient(loanApplicationRequest.getCustomerTaxId()).equals(DebtCustomerResult.SUCCESS);
    }
}
