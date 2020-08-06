package com.asc.loanservice.domain.loan.application;

import com.asc.loanservice.contracts.LoanApplicationView;
import com.asc.loanservice.contracts.LoanApplicationRequest;
import com.asc.loanservice.contracts.LoanApplicationResult;
import com.asc.loanservice.domain.loan.application.port.LoanApplicationDataProviderPort;
import com.asc.loanservice.domain.loan.application.port.LoanEvaluatorProviderPort;
import com.asc.loanservice.infrastructure.LoanEvaluatorProviderAdapter;

public class LoanApplicationFacade {

    private final LoanApplicationAggregate loanApplicationAggregate;

    public LoanApplicationFacade (
            LoanEvaluatorProviderPort loanEvaluatorProviderPort,
            LoanApplicationDataProviderPort loanApplicationDataProviderPort){

        this.loanApplicationAggregate =
                new LoanApplicationAggregate(loanEvaluatorProviderPort, loanApplicationDataProviderPort);
    }

    public LoanApplicationResult register(LoanApplicationRequest loanApplicationRequest) {
        return loanApplicationAggregate.register(loanApplicationRequest);
    }

    public LoanApplicationView getByNumber(String loanNumber){
        return null;
    }
}
