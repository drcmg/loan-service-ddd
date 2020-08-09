package com.asc.loanservice.domain.loan.evaluation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanEvaluationRepository extends CrudRepository<LoanEvaluationRoot, Long> {

    Optional<LoanEvaluationRoot> findByLoanRequestNumber(String loanRequestNumber);
}
