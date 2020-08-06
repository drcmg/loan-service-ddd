package com.asc.loanservice.domain.loan.application;

import com.asc.loanservice.contracts.LoanApplicationCreateInput;
import com.asc.loanservice.domain.loan.application.port.LoanEvaluationStatus;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
class LoanApplicationRoot {

    private final Customer customer;
    private final Loan loan;
    private final LoanEvaluationStatus loanEvaluationStatus;
    private final LocalDateTime createdDate;

    static LoanApplicationRoot create(LoanApplicationCreateInput loanApplicationCreateInput) {
        return LoanApplicationRoot.builder()
                .customer(Customer.builder()
                        .customerName(loanApplicationCreateInput.getCustomerName())
                        .customerBirthday(loanApplicationCreateInput.getCustomerBirthday())
                        .customerTaxId(loanApplicationCreateInput.getCustomerTaxId())
                        .customerMonthlyIncome(loanApplicationCreateInput.getCustomerMonthlyIncome())
                        .build()
                )
                .loan(Loan.builder()
                        .loanAmount(loanApplicationCreateInput.getLoanAmount())
                        .numberOfInstallments(loanApplicationCreateInput.getNumberOfInstallments())
                        .firstInstallmentDate(loanApplicationCreateInput.getFirstInstallmentDate())
                        .build()
                )
                .build();
    }
}
