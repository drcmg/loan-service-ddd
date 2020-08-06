package com.asc.loanservice.infrastructure.repository.model;



import com.asc.loanservice.domain.loan.application.LoanEvaluationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@Entity
public class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    @Embedded
    private final Customer customer;

    @Embedded
    private final Loan loan;

    @Enumerated(value = EnumType.STRING)
    private final LoanEvaluationStatus loanEvaluationStatus;

    @CreationTimestamp
    private final LocalDateTime createdDate;
}
