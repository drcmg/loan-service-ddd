package com.asc.loanservice.infrastructure.repository;

import com.asc.loanservice.infrastructure.repository.model.LoanApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanApplicationRepository extends CrudRepository<LoanApplication, Long> {
    Optional<LoanApplication> findByLoanRequestNumber(String loanRequestNumber);
}
