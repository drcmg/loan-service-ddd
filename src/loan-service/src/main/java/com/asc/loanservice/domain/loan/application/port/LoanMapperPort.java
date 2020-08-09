package com.asc.loanservice.domain.loan.application.port;

import com.asc.loanservice.domain.loan.application.contract.LoanApplicationCreateInput;
import com.asc.loanservice.domain.loan.application.contract.LoanApplicationRequest;


public interface LoanMapperPort {

    LoanApplicationCreateInput createInput(LoanApplicationRequest loanApplicationRequest);
}
