package com.asc.loanservice.infrastructure;

import com.asc.loanservice.domain.loan.application.port.LoanApplicationDataProviderPort;
import com.asc.loanservice.infrastructure.repository.LoanApplicationRepository;
import com.asc.loanservice.infrastructure.repository.model.LoanApplication;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class LoanApplicationDataProviderAdapter implements LoanApplicationDataProviderPort {

    private final LoanApplicationRepository loanApplicationRepository;

    @Override
    public LoanApplication save(LoanApplication loanApplication) {
        return loanApplicationRepository.save(loanApplication);
    }

    @Override
    public Optional<LoanApplication> findById(Long id) {
        return loanApplicationRepository.findById(id);
    }
}
