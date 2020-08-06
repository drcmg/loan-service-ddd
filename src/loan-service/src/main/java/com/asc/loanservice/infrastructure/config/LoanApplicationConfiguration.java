package com.asc.loanservice.infrastructure.config;

import com.asc.loanservice.domain.loan.application.LoanApplicationFacade;
import com.asc.loanservice.domain.loan.application.port.LoanApplicationDataProviderPort;
import com.asc.loanservice.domain.loan.application.port.LoanEvaluatorProviderPort;
import com.asc.loanservice.domain.loan.application.port.LoanMapperPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoanApplicationConfiguration {

    @Bean
    LoanApplicationFacade loanApplicationFacade(
            LoanEvaluatorProviderPort loanEvaluatorProvider,
            LoanApplicationDataProviderPort loanApplicationDataProvider,
            LoanMapperPort loanMapper){
        return new LoanApplicationFacade(
                            loanEvaluatorProvider,
                            loanApplicationDataProvider,
                            loanMapper);
    }
}
