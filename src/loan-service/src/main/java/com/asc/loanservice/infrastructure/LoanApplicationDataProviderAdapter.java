package com.asc.loanservice.infrastructure;

import com.asc.loanservice.domain.loan.application.port.LoanApplicationDataProviderPort;
import com.asc.loanservice.infrastructure.repository.LoanApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LoanApplicationDataProviderAdapter implements LoanApplicationDataProviderPort {

    private final LoanApplicationRepository loanApplicationRepository;

}
