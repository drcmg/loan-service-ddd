package com.asc.loanservice.domain.loan.application;

import com.asc.loanservice.contracts.LoanApplicationCreateInput;
import com.asc.loanservice.contracts.LoanApplicationRequest;
import org.mapstruct.Mapper;

@Mapper
public interface LoanMapper {
    LoanApplicationCreateInput createInput(LoanApplicationRequest loanApplicationRequest);
}
