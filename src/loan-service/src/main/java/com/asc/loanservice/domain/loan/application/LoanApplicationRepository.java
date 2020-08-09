package com.asc.loanservice.domain.loan.application;

import com.asc.loanservice.infrastructure.repository.model.LoanApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
interface LoanApplicationRepository extends CrudRepository<LoanApplicationRoot, Long> {

    Optional<LoanApplicationRoot> findByLoanRequestNumber(String loanRequestNumber);
}
