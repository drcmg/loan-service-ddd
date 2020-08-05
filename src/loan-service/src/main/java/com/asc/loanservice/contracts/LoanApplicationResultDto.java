package com.asc.loanservice.contracts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanApplicationResultDto {
    private String loanRequestNumber;
    private LoanApplicationEvaluationStatus evaluationResult;
}
