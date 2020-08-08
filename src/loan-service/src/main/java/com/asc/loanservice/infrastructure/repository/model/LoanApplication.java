package com.asc.loanservice.infrastructure.repository.model;

import com.asc.loanservice.infrastructure.api.contract.LoanApplicationEvaluationStatus;
import com.asc.loanservice.infrastructure.api.contract.LoanApplicationView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Builder
@Getter
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "loanRequestNumber"
        })
})
public class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String loanRequestNumber;
    private String customerName;
    private LocalDate customerBirthday;
    private String customerTaxId;
    private BigDecimal customerMonthlyIncome;
    private BigDecimal loanAmount;
    private Integer numberOfInstallments;
    private LocalDate firstInstallmentDate;
    @Enumerated(value = EnumType.STRING)
    private LoanEvaluationStatus loanEvaluationStatus;
    @CreationTimestamp
    private LocalDateTime createdDate;

    public LoanApplicationView prepareLoanApplicationView(){
        return LoanApplicationView.builder()
                            .loanRequestNumber(loanRequestNumber)
                            .customerName(customerName)
                            .customerBirthday(customerBirthday)
                            .customerTaxId(customerTaxId)
                            .customerMonthlyIncome(customerMonthlyIncome)
                            .loanAmount(loanAmount)
                            .numberOfInstallments(numberOfInstallments)
                            .firstInstallmentDate(firstInstallmentDate)
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
