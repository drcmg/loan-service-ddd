package com.asc.loanservice.domain.loan.application;

import com.asc.loanservice.domain.loan.application.contract.LoanApplicationRequest;
import com.asc.loanservice.domain.loan.application.contract.LoanApplicationResult;
import com.asc.loanservice.domain.loan.application.contract.LoanApplicationView;
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
    @NonNull private final LoanMapper loanMapper;

    public LoanApplicationResult register(LoanApplicationRequest loanApplicationRequest) {
        LoanApplicationRoot loanApplicationRoot =
                LoanApplicationRoot.create(loanMapper.createInput(loanApplicationRequest));
        LoanEvaluationResult loanEvaluationResult =
                loanEvaluatorProvider.evaluate(loanApplicationRequest, loanApplicationRoot.getLoanRequestNumber());

//        loanApplicationRoot.changeLoanEvaluationStatus(loanEvaluationResult);
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
