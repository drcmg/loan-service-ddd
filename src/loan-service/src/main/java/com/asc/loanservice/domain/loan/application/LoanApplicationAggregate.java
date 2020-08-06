package com.asc.loanservice.domain.loan.application;

import com.asc.loanservice.contracts.LoanApplicationCreateInput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Builder
@AllArgsConstructor
@NoArgsConstructor
class LoanApplicationAggregate {

    private Customer customer;
    private Loan loan;
    private EvaluationStatus evaluationStatus;
    private LocalDateTime createdDate;

    static LoanApplicationAggregate create(LoanApplicationCreateInput loanApplicationCreateInput){
        return LoanApplicationAggregate.builder()
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
