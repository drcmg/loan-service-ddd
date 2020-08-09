package com.asc.loanservice.domain.loan.evaluation.south;


public interface DebtPort {

    DebtCustomerResult checkCustomerDebt(String customerTaxId);
}
