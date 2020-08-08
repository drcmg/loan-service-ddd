package com.asc.loanservice.infrastructure.constant;

import java.math.BigDecimal;


public final class Constants {

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final Integer MAX_CUSTOMER_AGE = 65;

    public static final Integer CALCULATION_SCALE = 10;
    public static final Integer RESULT_SCALE = 2;
    public static final BigDecimal PERCENT_OF_MONTHLY_INCOME = BigDecimal.valueOf(0.15);
    public static final BigDecimal ANNUAL_INTEREST_RATE = BigDecimal.valueOf(0.04);
    public static final BigDecimal ANNUAL_NUMBER_OF_INSTALMENTS = BigDecimal.valueOf(12L);
}
