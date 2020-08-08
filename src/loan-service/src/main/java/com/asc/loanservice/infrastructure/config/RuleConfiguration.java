package com.asc.loanservice.infrastructure.config;

import com.asc.loanservice.domain.loan.rule.CustomerAgeRule;
import com.asc.loanservice.domain.loan.rule.MaximumInstallmentAmountRule;
import com.asc.loanservice.domain.loan.rule.NotExistInDeptRegisterRule;
import com.asc.loanservice.domain.loan.rule.port.DebtPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RuleConfiguration {
    
    @Bean
    CustomerAgeRule customerAgeRule(){
        return new CustomerAgeRule();
    }

    @Bean
    MaximumInstallmentAmountRule maximumInstallmentAmountRule(){
        return new MaximumInstallmentAmountRule();
    }

    @Bean
    NotExistInDeptRegisterRule notExistInDeptRegisterRule(DebtPort debtPort){
        return new NotExistInDeptRegisterRule(debtPort);
    }
}
