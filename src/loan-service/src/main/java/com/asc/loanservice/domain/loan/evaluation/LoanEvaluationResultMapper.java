package com.asc.loanservice.domain.loan.evaluation;

import com.asc.loanservice.domain.loan.evaluation.dto.LoanEvaluationResult;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
interface LoanEvaluationResultMapper {

    LoanEvaluationResult mapResult(com.asc.loanservice.domain.loan.evaluation.LoanEvaluationResult loanEvaluationResult);
}
