package com.asc.loanservice.domain.loan.application;


import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String customerName;
    private LocalDate customerBirthday;
    private String customerTaxId;
    private BigDecimal customerMonthlyIncome;
}
