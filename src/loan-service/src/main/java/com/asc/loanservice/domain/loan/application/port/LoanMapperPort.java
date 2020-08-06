package com.asc.loanservice.domain.loan.application.port;

import com.asc.loanservice.infrastructure.api.contracts.LoanApplicationCreateInput;
import com.asc.loanservice.infrastructure.api.contracts.LoanApplicationRequest;

public interface LoanMapperPort {
    LoanApplicationCreateInput createInput(LoanApplicationRequest loanApplicationRequest);
}
