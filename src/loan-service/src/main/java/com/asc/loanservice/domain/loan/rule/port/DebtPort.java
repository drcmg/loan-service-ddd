package com.asc.loanservice.domain.loan.rule.port;

import com.asc.loanservice.external.DebtCustomerResult;

public interface DebtPort {
    DebtCustomerResult checkDebtClient(String customerTaxId);
}
