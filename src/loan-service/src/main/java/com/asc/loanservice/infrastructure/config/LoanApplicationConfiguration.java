package com.asc.loanservice.infrastructure.config;

import com.asc.loanservice.domain.loan.application.LoanApplicationFacade;
import com.asc.loanservice.infrastructure.LoanEvaluatorProviderAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoanApplicationConfiguration {

    @Bean
    LoanApplicationFacade loanApplicationFacade(LoanEvaluatorProviderAdapter loanEvaluatorProviderAdapter){
        return new LoanApplicationFacade(loanEvaluatorProviderAdapter);
    }
}
