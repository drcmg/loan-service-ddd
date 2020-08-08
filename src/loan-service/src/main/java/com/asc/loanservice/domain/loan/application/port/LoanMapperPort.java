package com.asc.loanservice.domain.loan.application.port;

import com.asc.loanservice.infrastructure.api.contract.LoanApplicationCreateInput;
import com.asc.loanservice.infrastructure.api.contract.LoanApplicationRequest;


public interface LoanMapperPort {

    LoanApplicationCreateInput createInput(LoanApplicationRequest loanApplicationRequest);
}
