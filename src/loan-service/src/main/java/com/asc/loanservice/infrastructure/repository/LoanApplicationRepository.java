package com.asc.loanservice.infrastructure.repository;

import com.asc.loanservice.infrastructure.repository.model.LoanApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanApplicationRepository extends CrudRepository<LoanApplication, Long> {
}
