package com.asc.loanservice.domain.loan.rule;

import com.asc.loanservice.infrastructure.api.contract.LoanApplicationRequest;

import java.time.LocalDate;
import java.time.Period;

import static com.asc.loanservice.infrastructure.constant.Constants.*;


public class CustomerAgeRule implements Rule {

    @Override
    public Boolean isValid(LoanApplicationRequest loanApplicationRequest) {
        LocalDate customerBirthday = loanApplicationRequest.getCustomerBirthday();
        LocalDate firstInstallmentDate = loanApplicationRequest.getFirstInstallmentDate();
        Integer numberOfInstallments = loanApplicationRequest.getNumberOfInstallments();

        LocalDate loanMaturityDate = firstInstallmentDate.plusMonths(numberOfInstallments);
        Period period = Period.between(customerBirthday, loanMaturityDate);

        return period.getYears() <= MAX_CUSTOMER_AGE;
    }
}
