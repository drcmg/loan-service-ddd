package com.asc.loanservice.domain.loan.application.port;

import com.asc.loanservice.infrastructure.repository.model.LoanApplication;

import java.util.Optional;

public interface LoanApplicationDataProviderPort {
    LoanApplication save(LoanApplication loanApplication);
    Optional<LoanApplication> findByLoanRequestNumber(String loanRequestNumber);
}
