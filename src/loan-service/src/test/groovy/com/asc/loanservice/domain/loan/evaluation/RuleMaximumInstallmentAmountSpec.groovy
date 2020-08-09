package com.asc.loanservice.domain.loan.evaluation

import com.asc.loanservice.domain.loan.application.dto.LoanApplicationRequest
import spock.lang.Specification


class RuleMaximumInstallmentAmountSpec extends Specification {

    def "single instalment amount should be less or equal 15% of customer monthly income"(){
        given: "a loan application request with example values"
        def loanApplicationRequest = LoanApplicationRequest.builder()
                .customerMonthlyIncome(BigDecimal.valueOf(5000L))
                .loanAmount(BigDecimal.valueOf(50_000L))
                .numberOfInstallments(100)
                .build()

        and: "RuleMaximumInstallmentAmount which is the class under test"
        def ruleMaximumInstallmentAmount = new RuleMaximumInstallmentAmount()

        when: "we ask for check the rule"
        def result = ruleMaximumInstallmentAmount.isValid(loanApplicationRequest)

        then: "rule should be fulfilled"
        result
    }

    def "single instalment amount should be greater than 15% of customer monthly income"(){
        given: "a loan application request with example values"
        def loanApplicationRequest = LoanApplicationRequest.builder()
                .customerMonthlyIncome(BigDecimal.valueOf(5000L))
                .loanAmount(BigDecimal.valueOf(50_000L))
                .numberOfInstallments(50)
                .build()

            and: "RuleMaximumInstallmentAmount which is the class under test"
        def ruleMaximumInstallmentAmount = new RuleMaximumInstallmentAmount()

        when: "we ask for check the rule"
        def result = ruleMaximumInstallmentAmount.isValid(loanApplicationRequest)

        then: "rule should not be fulfilled"
        !result
    }
}
