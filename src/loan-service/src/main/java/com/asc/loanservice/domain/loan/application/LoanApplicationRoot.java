package com.asc.loanservice.domain.loan.application;

import com.asc.loanservice.contracts.LoanApplicationCreateInput;
import com.asc.loanservice.contracts.LoanApplicationEvaluationStatus;
import com.asc.loanservice.contracts.LoanApplicationResult;
import com.asc.loanservice.contracts.LoanApplicationView;
import com.asc.loanservice.infrastructure.LoanEvaluationResult;
import com.asc.loanservice.infrastructure.repository.model.LoanApplication;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
class LoanApplicationRoot {

    private final Customer customer;
    private final Loan loan;
    private LoanEvaluationStatus loanEvaluationStatus;
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

    void changeLoanEvaluationStatus(LoanEvaluationResult loanEvaluationResult){
        this.loanEvaluationStatus = mapLoanEvaluationResultToStatus(loanEvaluationResult);
    }

    private LoanEvaluationStatus mapLoanEvaluationResultToStatus(LoanEvaluationResult loanEvaluationResult){
        return LoanEvaluationStatus.SUCCESS.name().equals(loanEvaluationResult.name())
                ? LoanEvaluationStatus.SUCCESS
                : LoanEvaluationStatus.FAILURE;
    }

    LoanApplicationResult prepareRegistrationResultView(LoanApplication loanApplication){
        return LoanApplicationResult.builder()
                .loanRequestNumber(loanApplication.getId().toString())
                .evaluationResult(
                        mapLoanEvaluationStatusToDto(loanApplication)
                )
                .build();
    }

    private LoanApplicationEvaluationStatus mapLoanEvaluationStatusToDto(LoanApplication loanApplication) {
        return LoanEvaluationStatus.SUCCESS.name().equals(loanApplication.getLoanEvaluationStatus().name())
               ? LoanApplicationEvaluationStatus.APPROVED
               : LoanApplicationEvaluationStatus.REJECTED;
    }

    LoanApplication toModel(){
        return LoanApplication.builder()
                .customerName(customer.getCustomerName())
                .customerBirthday(customer.getCustomerBirthday())
                .customerMonthlyIncome(customer.getCustomerMonthlyIncome())
                .customerTaxId(customer.getCustomerTaxId())
                .loanAmount(loan.getLoanAmount())
                .firstInstallmentDate(loan.getFirstInstallmentDate())
                .numberOfInstallments(loan.getNumberOfInstallments())
                .loanEvaluationStatus(mapLoanEvaluationStatusToModelStatus(loanEvaluationStatus))
                .build();
    }

    private com.asc.loanservice.infrastructure.repository.model.LoanEvaluationStatus mapLoanEvaluationStatusToModelStatus(LoanEvaluationStatus loanEvaluationResult){
        return com.asc.loanservice.infrastructure.repository.model.LoanEvaluationStatus.SUCCESS.name().equals(loanEvaluationResult.name())
                ? com.asc.loanservice.infrastructure.repository.model.LoanEvaluationStatus.SUCCESS
                : com.asc.loanservice.infrastructure.repository.model.LoanEvaluationStatus.FAILURE;
    }
}
