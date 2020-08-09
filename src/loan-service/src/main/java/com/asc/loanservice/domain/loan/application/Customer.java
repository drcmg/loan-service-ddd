package com.asc.loanservice.domain.loan.application;

import lombok.Builder;
import lombok.Getter;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Builder
@Embeddable
public class Customer {

    private final String customerName;
    private final LocalDate customerBirthday;
    private final String customerTaxId;
    private final BigDecimal customerMonthlyIncome;
}
