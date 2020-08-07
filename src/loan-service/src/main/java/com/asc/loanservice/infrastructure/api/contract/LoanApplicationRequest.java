package com.asc.loanservice.infrastructure.api.contract;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import static com.asc.loanservice.infrastructure.constant.Constants.DATE_FORMAT;

@Builder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanApplicationRequest {

    @NotNull
    @NotBlank
    private String customerName;
    @NotNull
    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDate customerBirthday;
    @NotNull
    @NotBlank
    private String customerTaxId;
    @NotNull
    @Positive
    private BigDecimal customerMonthlyIncome;
    @NotNull
    @Positive
    private BigDecimal loanAmount;
    @NotNull
    @Positive
    private Integer numberOfInstallments;
    @NotNull
    @Future
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDate firstInstallmentDate;
}
