package com.asc.loanservice.domain.loan.application;

import com.asc.loanservice.infrastructure.api.contract.LoanApplicationRequest;
import com.asc.loanservice.infrastructure.api.contract.LoanApplicationResult;
import com.asc.loanservice.infrastructure.api.contract.LoanApplicationView;
import com.asc.loanservice.domain.loan.application.port.LoanApplicationDataProviderPort;
import com.asc.loanservice.domain.loan.application.port.LoanEvaluatorProviderPort;
import com.asc.loanservice.domain.loan.application.port.LoanMapperPort;
import com.asc.loanservice.infrastructure.LoanEvaluationResult;
import com.asc.loanservice.infrastructure.repository.model.LoanApplication;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;

import java.util.NoSuchElementException;


@Builder
@AllArgsConstructor
class LoanApplicationAggregate {

    @NonNull private final LoanEvaluatorProviderPort loanEvaluatorProvider;
    @NonNull private final LoanApplicationDataProviderPort loanApplicationDataProvider;
    @NonNull private final LoanMapperPort loanMapper;

    public LoanApplicationResult register(LoanApplicationRequest loanApplicationRequest) {
        LoanApplicationRoot loanApplicationRoot =
                LoanApplicationRoot.create(loanMapper.createInput(loanApplicationRequest));
        LoanEvaluationResult loanEvaluationResult = loanEvaluatorProvider.evaluate(loanApplicationRequest);

        loanApplicationRoot.changeLoanEvaluationStatus(loanEvaluationResult);
        LoanApplication loanApplication = loanApplicationDataProvider.save(loanApplicationRoot.toModel());
        return loanApplicationRoot.prepareRegistrationResultView(loanApplication);
    }

    public LoanApplicationView getByNumber(String loanNumber){
        return loanApplicationDataProvider.findById(Long.valueOf(loanNumber))
                .orElseThrow(NoSuchElementException::new)
                .prepareView();
    }
}
