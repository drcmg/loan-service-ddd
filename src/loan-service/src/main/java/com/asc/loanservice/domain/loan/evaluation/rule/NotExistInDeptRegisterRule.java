package com.asc.loanservice.domain.loan.evaluation.rule;

import com.asc.loanservice.domain.loan.evaluation.south.DebtPort;
import com.asc.loanservice.domain.loan.evaluation.south.DebtCustomerResult;
import com.asc.loanservice.domain.loan.application.contract.LoanApplicationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
class NotExistInDeptRegisterRule implements Rule {

    private final DebtPort debtPort;

    @Override
    public Boolean isValid(LoanApplicationRequest loanApplicationRequest) {
        return debtPort.checkCustomerDebt(loanApplicationRequest.getCustomerTaxId())
                .equals(DebtCustomerResult.SUCCESS);
    }
}
