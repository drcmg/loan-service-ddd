package com.asc.loanservice.domain.loan.application;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
interface LoanApplicationRepository extends CrudRepository<LoanApplicationRoot, Long> {

    Optional<LoanApplicationRoot> findByLoanRequestNumber(String loanRequestNumber);
}
