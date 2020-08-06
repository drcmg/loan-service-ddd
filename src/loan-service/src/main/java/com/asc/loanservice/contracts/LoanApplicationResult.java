package com.asc.loanservice.contracts;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanApplicationResult {
    private String loanRequestNumber;
    private LoanApplicationEvaluationStatus evaluationResult;
}
