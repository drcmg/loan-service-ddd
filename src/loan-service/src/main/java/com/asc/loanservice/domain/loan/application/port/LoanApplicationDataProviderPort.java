package com.asc.loanservice.domain.loan.application.port;

import com.asc.loanservice.infrastructure.repository.model.LoanApplication;

public interface LoanApplicationDataProviderPort {

    LoanApplication save(LoanApplication loanApplication);
}
