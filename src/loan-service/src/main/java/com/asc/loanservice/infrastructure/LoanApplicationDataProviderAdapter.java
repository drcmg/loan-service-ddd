package com.asc.loanservice.infrastructure;

import com.asc.loanservice.domain.loan.application.port.LoanApplicationDataProviderPort;
import com.asc.loanservice.infrastructure.repository.LoanApplicationRepository;
import com.asc.loanservice.infrastructure.repository.model.LoanApplication;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LoanApplicationDataProviderAdapter implements LoanApplicationDataProviderPort {

    private final LoanApplicationRepository loanApplicationRepository;

    @Override
    public LoanApplication save(LoanApplication loanApplication) {
        return loanApplicationRepository.save(loanApplication);
    }
}
