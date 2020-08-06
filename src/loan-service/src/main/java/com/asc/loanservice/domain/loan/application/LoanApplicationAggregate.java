package com.asc.loanservice.domain.loan.application;

import com.asc.loanservice.contracts.LoanApplicationCreateInput;
import com.asc.loanservice.contracts.LoanApplicationRequest;
import com.asc.loanservice.contracts.LoanApplicationResult;
import com.asc.loanservice.contracts.LoanApplicationView;
import com.asc.loanservice.domain.loan.evaluation.LoanEvaluationAggregate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanApplicationRoot {

    private Customer customer;
    private Loan loan;
    private EvaluationStatus evaluationStatus;
    private LocalDateTime createdDate;





}
