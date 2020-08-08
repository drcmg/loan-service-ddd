package com.asc.loanservice.external.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class DebtCustomerRestTemplateConfiguration {

    @Bean("debtCustomerRestTemplate")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
