package com.asc.loanservice.domain.loan.application.port;

import com.asc.loanservice.contracts.LoanApplicationRequest;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class LoanEvaluationFacade {

    private final Map<String, RulePort> rules;

    static LoanEvaluationFacade create(Map<String, RulePort> rules){
        return new LoanEvaluationFacade(rules);
    }

    public EvaluationResult evaluate(LoanApplicationRequest loanApplicationRequest){
        return rules.isEmpty()
                ? EvaluationResult.SUCCESS
                : (
                        rules.values().stream()
                                    .map(rule -> rule.isValid(loanApplicationRequest))
                                    .anyMatch(result -> result.equals(false))
                                ? EvaluationResult.FAILURE
                                : EvaluationResult.SUCCESS
                );
    }
}
