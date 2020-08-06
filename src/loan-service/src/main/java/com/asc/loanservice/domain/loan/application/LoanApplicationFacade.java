package com.asc.loanservice.domain.loan.application;

import com.asc.loanservice.contracts.LoanApplicationView;
import com.asc.loanservice.contracts.LoanApplicationRequest;
import com.asc.loanservice.contracts.LoanApplicationResult;
import com.asc.loanservice.infrastructure.LoanEvaluatorProviderAdapter;

public class LoanApplicationFacade {

    private final LoanApplicationAggregate loanApplicationAggregate;

    public LoanApplicationFacade (
            LoanEvaluatorProviderAdapter loanEvaluatorProviderAdapter){

        this.loanApplicationAggregate =
                new LoanApplicationAggregate(loanEvaluatorProviderAdapter);
    }

    public LoanApplicationResult register(LoanApplicationRequest loanApplicationRequest) {
        return loanApplicationAggregate.register(loanApplicationRequest);
    }

    public LoanApplicationView getByNumber(String loanNumber){
        return null;
    }
}
