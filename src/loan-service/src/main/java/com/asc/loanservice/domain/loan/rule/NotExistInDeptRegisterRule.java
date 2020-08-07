package com.asc.loanservice.domain.loan.rule;


import com.asc.loanservice.domain.loan.rule.port.DebtPort;
import com.asc.loanservice.external.DebtCustomerResult;
import com.asc.loanservice.infrastructure.api.contracts.LoanApplicationRequest;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class NotExistInDeptRegisterRule implements Rule {

    private final DebtPort debtPort;

    @Override
    public Boolean isValid(LoanApplicationRequest loanApplicationRequest) {
        return debtPort.checkDebtClient(loanApplicationRequest.getCustomerTaxId()).equals(DebtCustomerResult.SUCCESS);
    }
}
