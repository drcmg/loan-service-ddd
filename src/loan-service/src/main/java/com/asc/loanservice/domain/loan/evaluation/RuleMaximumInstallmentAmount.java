package com.asc.loanservice.domain.loan.evaluation;

import com.asc.loanservice.domain.loan.application.contract.LoanApplicationRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.asc.loanservice.constant.Constants.*;

@Component
class RuleMaximumInstallmentAmount implements Rule {

    @Override
    public Boolean isValid(LoanApplicationRequest loanApplicationRequest) {
        BigDecimal customerMonthlyIncome = loanApplicationRequest.getCustomerMonthlyIncome();
        BigDecimal loanAmount = loanApplicationRequest.getLoanAmount();
        Integer numberOfInstallments = loanApplicationRequest.getNumberOfInstallments();

        BigDecimal amountOfMonthlyInstallment = calculatePMT(numberOfInstallments, loanAmount);
        BigDecimal maximumInstallmentAmount = customerMonthlyIncome.multiply(PERCENT_OF_MONTHLY_INCOME);

        return amountOfMonthlyInstallment.compareTo(maximumInstallmentAmount) <= 0;
    }

    /*
        I = (N * r) / (k * (1 - (k / (k + r))^n))

        I - amount of equal monthly installment
        N - amount of loan
        r - annual interest rate
        k - annual amount of installments
        n - number of installments
    */
    private BigDecimal calculatePMT(Integer numberOfInstallments, BigDecimal loanAmount){
        //product = N * r
        BigDecimal product = ANNUAL_INTEREST_RATE.multiply(loanAmount);

        //divisor = k + r
        BigDecimal divisor = ANNUAL_NUMBER_OF_INSTALMENTS.add(ANNUAL_INTEREST_RATE);
        //base = k / divisor
        BigDecimal base = ANNUAL_NUMBER_OF_INSTALMENTS.divide(divisor, CALCULATION_SCALE, RoundingMode.HALF_UP);
        //power = base ^ n
        BigDecimal power = base.pow(numberOfInstallments).setScale(CALCULATION_SCALE, RoundingMode.HALF_UP);
        //mainDivisor = k * (1 - power)
        BigDecimal mainDivisor = BigDecimal.ONE.subtract(power).multiply(ANNUAL_NUMBER_OF_INSTALMENTS);

        return product.divide(mainDivisor, RESULT_SCALE, RoundingMode.HALF_UP);
    }
}
