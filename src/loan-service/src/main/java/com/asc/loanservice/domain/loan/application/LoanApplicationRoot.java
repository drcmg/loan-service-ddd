package com.asc.loanservice.domain.loan.application;

import com.asc.loanservice.domain.loan.application.contract.LoanApplicationCreateInput;
import com.asc.loanservice.domain.loan.application.contract.LoanApplicationEvaluationStatus;
import com.asc.loanservice.domain.loan.application.contract.LoanApplicationResult;
import com.asc.loanservice.domain.loan.application.contract.LoanApplicationView;
import com.asc.loanservice.domain.loan.application.south.LoanEvaluationResult;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.UUID;
import java.time.LocalDateTime;


@Builder
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "loanRequestNumber"
        })
})
class LoanApplicationRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    private final String loanRequestNumber;
    @Embedded
    private final Customer customer;
    @Embedded
    private final Loan loan;
    @CreationTimestamp
    private final LocalDateTime createdDate;
    @Enumerated(value = EnumType.STRING)
    private LoanEvaluationStatus loanEvaluationStatus;

    static LoanApplicationRoot create(LoanApplicationCreateInput loanApplicationCreateInput) {
        return LoanApplicationRoot.builder()
                .loanRequestNumber(UUID.randomUUID().toString())
                .customer(
                    Customer.builder()
                                .customerName(loanApplicationCreateInput.getCustomerName())
                                .customerBirthday(loanApplicationCreateInput.getCustomerBirthday())
                                .customerTaxId(loanApplicationCreateInput.getCustomerTaxId())
                                .customerMonthlyIncome(loanApplicationCreateInput.getCustomerMonthlyIncome())
                            .build()
                )
                .loan(
                    Loan.builder()
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

    LoanApplicationResult prepareRegistrationResultView(){
        return LoanApplicationResult.builder()
                .loanRequestNumber(loanRequestNumber)
                .evaluationResult(
                        mapLoanEvaluationStatusToDto()
                )
            .build();
    }

    private LoanApplicationEvaluationStatus mapLoanEvaluationStatusToDto() {
        return LoanEvaluationStatus.SUCCESS.name().equals(loanEvaluationStatus.name())
               ? LoanApplicationEvaluationStatus.APPROVED
               : LoanApplicationEvaluationStatus.REJECTED;
    }

    public LoanApplicationView prepareLoanApplicationView(){
        return LoanApplicationView.builder()
                .loanRequestNumber(loanRequestNumber)
                .customerName(customer.getCustomerName())
                .customerBirthday(customer.getCustomerBirthday())
                .customerTaxId(customer.getCustomerTaxId())
                .customerMonthlyIncome(customer.getCustomerMonthlyIncome())
                .loanAmount(loan.getLoanAmount())
                .numberOfInstallments(loan.getNumberOfInstallments())
                .firstInstallmentDate(loan.getFirstInstallmentDate())
                .registrationDate(createdDate)
                .evaluationResult(
                        mapLoanEvaluationStatusToDto(loanEvaluationStatus)
                )
                .build();
    }

    private LoanApplicationEvaluationStatus mapLoanEvaluationStatusToDto(LoanEvaluationStatus loanEvaluationStatus) {
        return LoanEvaluationStatus.SUCCESS.name().equals(loanEvaluationStatus.name())
                ? LoanApplicationEvaluationStatus.APPROVED
                : LoanApplicationEvaluationStatus.REJECTED;
    }
}
