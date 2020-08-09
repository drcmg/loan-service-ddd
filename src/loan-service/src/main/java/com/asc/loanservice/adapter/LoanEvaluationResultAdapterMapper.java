package com.asc.loanservice.adapter;

import com.asc.loanservice.domain.loan.evaluation.dto.LoanEvaluationResult;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface LoanEvaluationResultAdapterMapper {

    com.asc.loanservice.domain.loan.application.south.
            LoanEvaluationResult mapResult(LoanEvaluationResult loanEvaluationResult);
}
