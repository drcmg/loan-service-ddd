package com.asc.loanservice.domain.loan.evaluation

import com.asc.loanservice.domain.loan.application.dto.LoanApplicationRequest
import spock.lang.Specification

class RuleNotExistInDeptRegisterSpec extends Specification {

    DebtPort debtPort

    def setup(){
        debtPort = Mock(DebtPort)
    }


    def "customer should not be on debtor register"(){
        given: "a loan application request with example values"
        def loanApplicationRequest = LoanApplicationRequest.builder()
                .customerTaxId("123456789")
                .build()

        debtPort.checkCustomerDebt(loanApplicationRequest.getCustomerTaxId()) >> DebtCustomerResult.SUCCESS

        and: "RuleNotExistInDeptRegister which is the class under test"
        def ruleNotExistInDeptRegister = new RuleNotExistInDeptRegister(debtPort)

        when: "we ask for check the rule"
        def result = ruleNotExistInDeptRegister.isValid(loanApplicationRequest)

        then: "rule should be fulfilled"
        result
    }

    def "customer should be on debtor register"(){
        given: "a loan application request with example values"
        def loanApplicationRequest = LoanApplicationRequest.builder()
                .customerTaxId("35062600206")
                .build()

        debtPort.checkCustomerDebt(loanApplicationRequest.getCustomerTaxId()) >> DebtCustomerResult.FAILURE

        and: "RuleNotExistInDeptRegister which is the class under test"
        def ruleNotExistInDeptRegister = new RuleNotExistInDeptRegister(debtPort)

        when: "we ask for check the rule"
        def result = ruleNotExistInDeptRegister.isValid(loanApplicationRequest)

        then: "rule should not be fulfilled"
        !result
    }
}
