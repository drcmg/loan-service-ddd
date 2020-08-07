package com.asc.loanservice.infrastructure;

import com.asc.loanservice.infrastructure.api.contract.LoanApplicationRequest;
import com.asc.loanservice.domain.loan.application.port.LoanEvaluatorProviderPort;
import com.asc.loanservice.domain.loan.rule.Rule;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoanEvaluatorProviderAdapter implements LoanEvaluatorProviderPort {

    private final Map<String, Rule> rules;

    public LoanEvaluatorProviderAdapter(Map<String, Rule> rules) {
        this.rules = rules;
    }

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
