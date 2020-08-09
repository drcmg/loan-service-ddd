package com.asc.loanservice.domain.loan.rule;

import com.asc.loanservice.domain.loan.rule.port.DebtPort;
import com.asc.loanservice.domain.loan.rule.port.DebtCustomerResult;
import com.asc.loanservice.domain.loan.application.contract.LoanApplicationRequest;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class NotExistInDeptRegisterRule implements Rule {

    private final DebtPort debtPort;

    @Override
    public Boolean isValid(LoanApplicationRequest loanApplicationRequest) {
        return debtPort.checkCustomerDebt(loanApplicationRequest.getCustomerTaxId())
                .equals(DebtCustomerResult.SUCCESS);
    }
}
