package com.asc.loanservice.domain.loan.evaluation;

import com.asc.loanservice.domain.loan.application.dto.LoanApplicationRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

import static com.asc.loanservice.constant.Constants.*;

@Component
class RuleCustomerAge implements Rule {

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
