package com.asc.loanservice.infrastructure.repository.model;



import com.asc.loanservice.infrastructure.api.contracts.LoanApplicationEvaluationStatus;
import com.asc.loanservice.infrastructure.api.contracts.LoanApplicationView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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


    public LoanApplicationView prepareView(){
        return LoanApplicationView.builder()
                .loanRequestNumber(id.toString())
                .customerName(customerName)
                .customerBirthday(customerBirthday)
                .customerTaxId(customerTaxId)
                .customerMonthlyIncome(customerMonthlyIncome)
                .loanAmount(loanAmount)
                .numberOfInstallments(numberOfInstallments)
                .firstInstallmentDate(firstInstallmentDate)
                .registrationDate(createdDate)
                .evaluationResult(mapLoanEvaluationStatusToDto(loanEvaluationStatus))
                .build();
    }

    private LoanApplicationEvaluationStatus mapLoanEvaluationStatusToDto(LoanEvaluationStatus loanEvaluationStatus) {
        return LoanEvaluationStatus.SUCCESS.name().equals(loanEvaluationStatus.name())
                ? LoanApplicationEvaluationStatus.APPROVED
                : LoanApplicationEvaluationStatus.REJECTED;
    }
}
