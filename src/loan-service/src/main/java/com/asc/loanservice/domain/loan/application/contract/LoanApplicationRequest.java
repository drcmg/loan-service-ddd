package com.asc.loanservice.domain.loan.application.contract;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import static com.asc.loanservice.constant.Constants.DATE_FORMAT;
import static com.asc.loanservice.constant.ValidationOrder.*;


@Getter
public class LoanApplicationRequest {

    @NotNull(groups = Order2.class)
    @NotBlank(groups = Order3.class)
    private String customerName;

    @NotNull(groups = Order4.class)
    @Past(groups = Order5.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDate customerBirthday;

    @NotNull(groups = Order6.class)
    @NotBlank(groups = Order7.class)
    private String customerTaxId;

    @NotNull(groups = Order8.class)
    @Positive(groups = Order9.class)
    private BigDecimal customerMonthlyIncome;

    @NotNull(groups = Order10.class)
    @Positive(groups = Order11.class)
    private BigDecimal loanAmount;

    @NotNull(groups = Order12.class)
    @Positive(groups = Order13.class)
    private Integer numberOfInstallments;

    @NotNull(groups = Order14.class)
    @Future(groups = Order15.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDate firstInstallmentDate;
}
