package com.asc.loanservice.domain.loan.application;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
class Customer {

    private String customerName;
    private LocalDate customerBirthday;
    private String customerTaxId;
    private BigDecimal customerMonthlyIncome;
}
