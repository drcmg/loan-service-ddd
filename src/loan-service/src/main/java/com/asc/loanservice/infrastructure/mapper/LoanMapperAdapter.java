package com.asc.loanservice.infrastructure.mapper;

import com.asc.loanservice.contracts.LoanApplicationCreateInput;
import com.asc.loanservice.contracts.LoanApplicationRequest;
import com.asc.loanservice.domain.loan.application.port.LoanMapperPort;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface LoanMapperAdapter extends LoanMapperPort {
    LoanApplicationCreateInput createInput(LoanApplicationRequest loanApplicationRequest);
}
