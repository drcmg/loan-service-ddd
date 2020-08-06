package com.asc.loanservice.infrastructure.repository.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Embeddable
@AllArgsConstructor
public class Loan {

    private final BigDecimal loanAmount;
    private final Integer numberOfInstallments;
    private final LocalDate firstInstallmentDate;
}
