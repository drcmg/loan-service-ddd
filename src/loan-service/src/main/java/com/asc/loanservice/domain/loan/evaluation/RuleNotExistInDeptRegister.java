package com.asc.loanservice.domain.loan.evaluation;

import com.asc.loanservice.domain.loan.application.dto.LoanApplicationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
class RuleNotExistInDeptRegister implements Rule {

    private final DebtPort debtPort;

    @Override
    public Boolean isValid(LoanApplicationRequest loanApplicationRequest) {
        return debtPort.checkCustomerDebt(loanApplicationRequest.getCustomerTaxId())
                .equals(DebtCustomerResult.SUCCESS);
    }
}
