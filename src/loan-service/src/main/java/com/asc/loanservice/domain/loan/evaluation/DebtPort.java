package com.asc.loanservice.domain.loan.evaluation;


public interface DebtPort {

    DebtCustomerResult checkCustomerDebt(String customerTaxId);
}
