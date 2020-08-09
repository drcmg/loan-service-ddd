package com.asc.loanservice.domain.loan.evaluation;

import com.asc.loanservice.domain.loan.application.dto.LoanApplicationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Map;


@AllArgsConstructor
@Service
public class LoanEvaluationAggregate {

    private final Map<String, Rule> rules;
    private final LoanEvaluationRepository loanEvaluationRepository;
    private final LoanEvaluationResultMapper loanEvaluationResultMapper;

    public com.asc.loanservice.domain.loan.evaluation.dto.
            LoanEvaluationResult evaluate(LoanApplicationRequest loanApplicationRequest, String loanRequestNumber){
        LoanEvaluationResult loanEvaluationResult = rules.isEmpty()
                                                        ? LoanEvaluationResult.SUCCESS
                                                        : processNotEmptyRules(loanApplicationRequest);

        LoanEvaluationRoot loanEvaluationRoot = LoanEvaluationRoot.builder()
                .loanRequestNumber(loanRequestNumber)
                .loanEvaluationResult(loanEvaluationResult)
                .build();

        loanEvaluationRepository.save(loanEvaluationRoot);

        return loanEvaluationResultMapper.mapResult(loanEvaluationResult);
    }

    public com.asc.loanservice.domain.loan.evaluation.dto.
            LoanEvaluationResult getLoanApplicationEvaluationResult(String loanRequestNumber){

        LoanEvaluationRoot loanEvaluationRoot = loanEvaluationRepository.findByLoanRequestNumber(loanRequestNumber)
                .orElseThrow(EntityNotFoundException::new);

       return loanEvaluationResultMapper.mapResult(loanEvaluationRoot.getLoanEvaluationResult());
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
