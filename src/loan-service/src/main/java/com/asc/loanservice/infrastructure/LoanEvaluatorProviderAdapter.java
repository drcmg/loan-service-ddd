package com.asc.loanservice.infrastructure;

import com.asc.loanservice.domain.loan.application.port.LoanEvaluationResult;
import com.asc.loanservice.infrastructure.api.contract.LoanApplicationRequest;
import com.asc.loanservice.domain.loan.application.port.LoanEvaluatorProviderPort;
import com.asc.loanservice.domain.loan.rule.Rule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;


@AllArgsConstructor
@Service
public class LoanEvaluatorProviderAdapter implements LoanEvaluatorProviderPort {

    private final Map<String, Rule> rules;

    @Override
    public LoanEvaluationResult evaluate(LoanApplicationRequest loanApplicationRequest){
        return rules.isEmpty()
                ? LoanEvaluationResult.SUCCESS
                : processNotEmptyRules(loanApplicationRequest);
    }

    private LoanEvaluationResult processNotEmptyRules(LoanApplicationRequest loanApplicationRequest) {
        return isAnyRuleFailed(loanApplicationRequest)
                ? LoanEvaluationResult.FAILURE
                : LoanEvaluationResult.SUCCESS;
    }

    private boolean isAnyRuleFailed(LoanApplicationRequest loanApplicationRequest) {
        return rules.values().stream()
                .map(rule -> rule.isValid(loanApplicationRequest))
                .anyMatch(result -> result.equals(false));
    }
}
