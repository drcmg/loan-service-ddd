package com.asc.loanservice.domain.loan.application;

import com.asc.loanservice.infrastructure.api.contract.LoanApplicationView;
import com.asc.loanservice.infrastructure.api.contract.LoanApplicationRequest;
import com.asc.loanservice.infrastructure.api.contract.LoanApplicationResult;
import com.asc.loanservice.domain.loan.application.port.LoanApplicationDataProviderPort;
import com.asc.loanservice.domain.loan.application.port.LoanEvaluatorProviderPort;
import com.asc.loanservice.domain.loan.application.port.LoanMapperPort;

public class LoanApplicationFacade {

    private final LoanApplicationAggregate loanApplicationAggregate;

    public LoanApplicationFacade (
            LoanEvaluatorProviderPort loanEvaluatorProvider,
            LoanApplicationDataProviderPort loanApplicationDataProvider,
            LoanMapperPort loanMapper){
        this.loanApplicationAggregate = new LoanApplicationAggregate(
                        loanEvaluatorProvider,
                        loanApplicationDataProvider,
                        loanMapper
                );
    }

    public LoanApplicationResult register(LoanApplicationRequest loanApplicationRequest) {
        return loanApplicationAggregate.register(loanApplicationRequest);
    }

    public LoanApplicationView getByNumber(String loanNumber){
        return loanApplicationAggregate.getByNumber(loanNumber);
    }
}
