package com.asc.loanservice.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
public class CustomerCheckResultDto {
    private String customerTaxId;
    private Boolean isRegisteredDebtor;
}
