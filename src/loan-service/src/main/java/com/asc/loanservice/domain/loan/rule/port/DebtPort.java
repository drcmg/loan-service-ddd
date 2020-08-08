package com.asc.loanservice.domain.loan.rule.port;


public interface DebtPort {

    DebtCustomerResult checkCustomerDebt(String customerTaxId);
}
