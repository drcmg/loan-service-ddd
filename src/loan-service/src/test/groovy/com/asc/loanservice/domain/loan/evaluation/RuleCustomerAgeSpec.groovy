package com.asc.loanservice.domain.loan.evaluation

import com.asc.loanservice.domain.loan.application.dto.LoanApplicationRequest
import spock.lang.Specification

import java.time.LocalDate

class RuleCustomerAgeSpec extends Specification {

    def "customer's age should be less than 65 at the end of the loan"() {
        given: "a loan application request with example values"
        def loanApplicationRequest = LoanApplicationRequest.builder()
                .customerBirthday(LocalDate.of(2000, 12 ,25))
                .firstInstallmentDate(LocalDate.of(2020, 12 ,1))
                .numberOfInstallments(100)
                .build()

        and: "CustomerAgeRule which is the class under test"
        def ruleCustomerAge = new RuleCustomerAge()

        when: "we ask for check the rule"
        def result = ruleCustomerAge.isValid(loanApplicationRequest)

        then: "rule should be fulfilled"
        result
    }

    def "customer's age should be greater than 65 at the end of the loan"() {
        given: "a loan application request with example values"
        def loanApplicationRequest = LoanApplicationRequest.builder()
                .customerBirthday(LocalDate.of(1950, 12 ,25))
                .firstInstallmentDate(LocalDate.of(2020, 12 ,1))
                .numberOfInstallments(100)
                .build()

        and: "CustomerAgeRule which is the class under test"
        def ruleCustomerAge = new RuleCustomerAge()

        when: "we ask for check the rule"
        def result = ruleCustomerAge.isValid(loanApplicationRequest)

        then: "rule should not be fulfilled"
        !result
    }
}
