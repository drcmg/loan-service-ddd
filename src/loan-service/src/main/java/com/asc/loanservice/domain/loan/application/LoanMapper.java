package com.asc.loanservice.domain.loan.application;

import com.asc.loanservice.domain.loan.application.dto.LoanApplicationCreateInput;
import com.asc.loanservice.domain.loan.application.dto.LoanApplicationRequest;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper
@Component
interface LoanMapper {

    LoanApplicationCreateInput createInput(LoanApplicationRequest loanApplicationRequest);
}
