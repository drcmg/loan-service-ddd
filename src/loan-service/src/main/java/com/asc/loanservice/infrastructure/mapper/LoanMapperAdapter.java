package com.asc.loanservice.infrastructure.mapper;

import com.asc.loanservice.domain.loan.application.contract.LoanApplicationCreateInput;
import com.asc.loanservice.domain.loan.application.contract.LoanApplicationRequest;
import com.asc.loanservice.domain.loan.application.port.LoanMapperPort;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface LoanMapperAdapter extends LoanMapperPort {

    LoanApplicationCreateInput createInput(LoanApplicationRequest loanApplicationRequest);
}
