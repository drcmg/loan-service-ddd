package com.asc.loanservice.infrastructure.rule.port;

import com.asc.loanservice.external.DebtCustomerResult;

public interface DebtPort {

    DebtCustomerResult checkDebtClient(String customerTaxId);
}
