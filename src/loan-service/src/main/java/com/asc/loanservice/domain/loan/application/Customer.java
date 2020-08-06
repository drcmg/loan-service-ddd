package com.asc.loanservice.domain.loan.application;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;


@Builder
public class Customer {
    private String customerName;
    private LocalDate customerBirthday;
    private String customerTaxId;
    private BigDecimal customerMonthlyIncome;
}
