package com.asc.loanservice.domain.loan.application;

import com.asc.loanservice.contracts.LoanApplicationView;
import com.asc.loanservice.contracts.LoanApplicationRequest;
import com.asc.loanservice.contracts.LoanApplicationResult;

public class LoanApplicationFacade {

    private LoanApplicationAggregate loanApplicationAggregate;
    private LoanMapper loanMapper;

    public LoanApplicationFacade (){
        this.loanApplicationAggregate = new LoanApplicationAggregate();
    }

    public LoanApplicationResult register(LoanApplicationRequest loanRequest) {
        LoanApplicationAggregate loanApplicationAggregate =
                LoanApplicationAggregate.create(loanMapper.createInput(loanRequest));
        
        return null;
    }

    public LoanApplicationView getByNumber(String loanNumber){
        return null;
    }
}
