package com.asc.loanservice.domain.loan.application;

import com.asc.loanservice.contracts.LoanApplicationRequest;
import com.asc.loanservice.contracts.LoanApplicationResult;
import com.asc.loanservice.contracts.LoanApplicationView;
import com.asc.loanservice.infrastructure.LoanEvaluatorProviderAdapter;
import lombok.Builder;
import lombok.NonNull;


@Builder
class LoanApplicationAggregate {

    @NonNull
    private final LoanEvaluatorProviderAdapter loanEvaluatorProviderAdapter;

    private LoanMapper loanMapper;

    LoanApplicationAggregate(LoanEvaluatorProviderAdapter loanEvaluatorProviderAdapter){
        this.loanEvaluatorProviderAdapter = loanEvaluatorProviderAdapter;
    }

    public LoanApplicationResult register(LoanApplicationRequest loanRequest) {
        LoanApplicationRoot loanApplicationRoot =
                LoanApplicationRoot.create(loanMapper.createInput(loanRequest));



        return null;
    }

    public LoanApplicationView getByNumber(String loanNumber){
        return null;
    }
}
