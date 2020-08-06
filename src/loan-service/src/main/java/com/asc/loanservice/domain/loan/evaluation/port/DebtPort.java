package com.asc.loanservice.domain.loan.evaluation.port;

import com.asc.loanservice.external.DebtCustomerResult;

public interface DebtPort {
    DebtCustomerResult checkDebtClient(String customerTaxId);
}
