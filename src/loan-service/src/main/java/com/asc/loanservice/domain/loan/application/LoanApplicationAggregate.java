package com.asc.loanservice.domain.loan.application;

import com.asc.loanservice.domain.loan.application.dto.LoanApplicationRequest;
import com.asc.loanservice.domain.loan.application.dto.LoanApplicationResult;
import com.asc.loanservice.domain.loan.application.dto.LoanApplicationView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;


@Builder
@AllArgsConstructor
@Service
public class LoanApplicationAggregate {

    @NonNull private final LoanEvaluatorProviderPort loanEvaluatorProvider;
    @NonNull private final LoanApplicationRepository loanApplicationRepository;
    @NonNull private final LoanApplicationRequestMapper loanApplicationRequestMapper;

    public LoanApplicationResult register(LoanApplicationRequest loanApplicationRequest) {
        LoanApplicationRoot loanApplicationRoot =
                LoanApplicationRoot.create(loanApplicationRequestMapper.createInput(loanApplicationRequest));
        LoanEvaluationResult loanEvaluationResult =
                loanEvaluatorProvider.evaluate(loanApplicationRequest, loanApplicationRoot.getLoanRequestNumber());

        loanApplicationRepository.save(loanApplicationRoot);

        return loanApplicationRoot.prepareRegistrationResultView(loanEvaluationResult);
    }

    public LoanApplicationView getByNumber(String loanNumber){
        LoanEvaluationResult loanEvaluationResult = loanEvaluatorProvider.getLoanApplicationEvaluationResult(loanNumber);

        return loanApplicationRepository.findByLoanRequestNumber(loanNumber)
                .orElseThrow(EntityNotFoundException::new)
                .prepareLoanApplicationView(loanEvaluationResult);
    }
}
