package com.asc.loanservice.infrastructure;

import com.asc.loanservice.contracts.LoanApplicationRequest;
import com.asc.loanservice.domain.loan.application.port.LoanEvaluationStatus;
import com.asc.loanservice.domain.loan.application.port.LoanEvaluatorProviderPort;
import com.asc.loanservice.infrastructure.rule.Rule;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class LoanEvaluatorProviderAdapter implements LoanEvaluatorProviderPort {

    private final Map<String, Rule> rules;

    @Override
    public LoanEvaluationStatus evaluate(LoanApplicationRequest loanApplicationRequest){
        return rules.isEmpty()
                ? LoanEvaluationStatus.SUCCESS
                : (
                        rules.values().stream()
                                    .map(rule -> rule.isValid(loanApplicationRequest))
                                    .anyMatch(result -> result.equals(false))
                                ? LoanEvaluationStatus.FAILURE
                                : LoanEvaluationStatus.SUCCESS
                );
    }
}
