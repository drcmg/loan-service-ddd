package com.asc.loanservice.domain.loan.application.south;

import com.asc.loanservice.domain.loan.evaluation.dto.LoanEvaluationResult;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface LoanEvaluationResultAdapterMapper {

    com.asc.loanservice.domain.loan.application.LoanEvaluationResult mapResult(LoanEvaluationResult loanEvaluationResult);
}
