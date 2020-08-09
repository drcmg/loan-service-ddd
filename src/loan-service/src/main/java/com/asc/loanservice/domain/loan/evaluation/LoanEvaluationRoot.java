package com.asc.loanservice.domain.loan.evaluation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "loanRequestNumber"
        })
})
class LoanEvaluationRoot {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loanRequestNumber;

    @Getter
    @Enumerated(value = EnumType.STRING)
    private LoanEvaluationResult loanEvaluationResult;
}
