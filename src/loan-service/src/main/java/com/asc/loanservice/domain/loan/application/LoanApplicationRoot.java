package com.asc.loanservice.domain.loan.application;

import com.asc.loanservice.domain.loan.application.contract.LoanApplicationCreateInput;
import com.asc.loanservice.domain.loan.application.contract.LoanApplicationEvaluationStatus;
import com.asc.loanservice.domain.loan.application.contract.LoanApplicationResult;
import com.asc.loanservice.domain.loan.application.contract.LoanApplicationView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "loanRequestNumber"
        })
})
class LoanApplicationRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    private String loanRequestNumber;
    @Embedded
    private Customer customer;
    @Embedded
    private Loan loan;
    @CreationTimestamp
    private LocalDateTime createdDate;

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

    LoanApplicationResult prepareRegistrationResultView(LoanEvaluationResult loanEvaluationResult){
        return LoanApplicationResult.builder()
                .loanRequestNumber(loanRequestNumber)
                .evaluationResult(
                        mapLoanEvaluationStatusToDto(loanEvaluationResult)
                )
            .build();
    }

    LoanApplicationView prepareLoanApplicationView(LoanEvaluationResult loanEvaluationResult){
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
                        mapLoanEvaluationStatusToDto(loanEvaluationResult)
                )
                .build();
    }

    private LoanApplicationEvaluationStatus mapLoanEvaluationStatusToDto(LoanEvaluationResult loanEvaluationResult) {
        return LoanEvaluationStatus.SUCCESS.name().equals(loanEvaluationResult.name())
                ? LoanApplicationEvaluationStatus.APPROVED
                : LoanApplicationEvaluationStatus.REJECTED;
    }
}
