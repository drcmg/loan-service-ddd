package com.asc.loanservice.adapter;

import com.asc.loanservice.domain.loan.application.contract.LoanApplicationRequest;
import com.asc.loanservice.domain.loan.application.south.LoanEvaluationResult;
import com.asc.loanservice.domain.loan.application.south.LoanEvaluatorProviderPort;
import com.asc.loanservice.domain.loan.evaluation.LoanEvaluationAggregate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LoanEvaluatorProviderAdapter implements LoanEvaluatorProviderPort {

    private final LoanEvaluationAggregate loanEvaluationAggregate;
    private final LoanEvaluationResultAdapterMapper loanEvaluationResultAdapterMapper;

    @Override
    public LoanEvaluationResult evaluate(LoanApplicationRequest loanApplicationRequest,  String loanApplicationNumber) {

        com.asc.loanservice.domain.loan.evaluation.dto.
                LoanEvaluationResult loanEvaluationResult =
                    loanEvaluationAggregate.evaluate(loanApplicationRequest, loanApplicationNumber);

        return loanEvaluationResultAdapterMapper.mapResult(loanEvaluationResult);
    }

    @Override
    public LoanEvaluationResult getLoanApplicationEvaluationResult(String loanApplicationNumber) {

        com.asc.loanservice.domain.loan.evaluation.dto.
                LoanEvaluationResult loanEvaluationResult =
                    loanEvaluationAggregate.getLoanApplicationEvaluationResult(loanApplicationNumber);

        return loanEvaluationResultAdapterMapper.mapResult(loanEvaluationResult);
    }
}
