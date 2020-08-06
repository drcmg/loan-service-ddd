package com.asc.loanservice.infrastructure.rule;


import com.asc.loanservice.infrastructure.api.contracts.LoanApplicationRequest;
import com.asc.loanservice.external.DebtCustomerResult;
import com.asc.loanservice.infrastructure.rule.port.DebtPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class NotExistInDeptRegisterRule implements Rule {

    private final DebtPort debtPort;

    @Override
    public Boolean isValid(LoanApplicationRequest loanApplicationRequest) {
        return debtPort.checkDebtClient(loanApplicationRequest.getCustomerTaxId()).equals(DebtCustomerResult.SUCCESS);
    }
}
