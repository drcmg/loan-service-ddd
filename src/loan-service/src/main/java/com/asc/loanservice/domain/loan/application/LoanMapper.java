package com.asc.loanservice.domain.loan.application;

import com.asc.loanservice.domain.loan.application.contract.LoanApplicationCreateInput;
import com.asc.loanservice.domain.loan.application.contract.LoanApplicationRequest;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper
@Component
interface LoanMapper {

    LoanApplicationCreateInput createInput(LoanApplicationRequest loanApplicationRequest);
}
