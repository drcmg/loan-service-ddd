package com.asc.loanservice.infrastructure.repository.model;



import com.asc.loanservice.domain.loan.application.LoanEvaluationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
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

    @Embedded
    private Customer customer;

    @Embedded
    private Loan loan;

    @Enumerated(value = EnumType.STRING)
    private LoanEvaluationStatus loanEvaluationStatus;

    @CreationTimestamp
    private LocalDateTime createdDate;
}
