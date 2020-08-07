package com.asc.loanservice.infrastructure.api.contract;

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
