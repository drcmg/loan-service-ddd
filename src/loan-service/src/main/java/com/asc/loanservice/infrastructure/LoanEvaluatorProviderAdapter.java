package com.asc.loanservice.infrastructure;

import com.asc.loanservice.contracts.LoanApplicationRequest;
import com.asc.loanservice.domain.loan.application.port.LoanEvaluatorProviderPort;
import com.asc.loanservice.infrastructure.rule.Rule;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class LoanEvaluatorProviderAdapter implements LoanEvaluatorProviderPort {

    private final Map<String, Rule> rules;

    @Override
    public LoanEvaluationResult evaluate(LoanApplicationRequest loanApplicationRequest){
        return rules.isEmpty()
                ? LoanEvaluationResult.SUCCESS
                : (
                        rules.values().stream()
                                    .map(rule -> rule.isValid(loanApplicationRequest))
                                    .anyMatch(result -> result.equals(false))
                                ? LoanEvaluationResult.FAILURE
                                : LoanEvaluationResult.SUCCESS
                );
    }
}
