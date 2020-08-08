package com.asc.loanservice.domain.loan.rule.port;


public interface DebtPort {

    DebtCustomerResult checkDebtClient(String customerTaxId);
}
