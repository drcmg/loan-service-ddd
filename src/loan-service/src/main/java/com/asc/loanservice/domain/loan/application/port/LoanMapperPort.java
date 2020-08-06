package com.asc.loanservice.domain.loan.application.port;

import com.asc.loanservice.contracts.LoanApplicationCreateInput;
import com.asc.loanservice.contracts.LoanApplicationRequest;

public interface LoanMapperPort {
    LoanApplicationCreateInput createInput(LoanApplicationRequest loanApplicationRequest);
}
