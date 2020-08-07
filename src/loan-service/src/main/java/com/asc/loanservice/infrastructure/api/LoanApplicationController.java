package com.asc.loanservice.infrastructure.api;

import com.asc.loanservice.infrastructure.api.contract.LoanApplicationView;
import com.asc.loanservice.infrastructure.api.contract.LoanApplicationRequest;
import com.asc.loanservice.infrastructure.api.contract.LoanApplicationResult;
import com.asc.loanservice.domain.loan.application.LoanApplicationFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/loans")
public class LoanApplicationController {

    private final LoanApplicationFacade loanApplicationFacade;

    @PostMapping
    public LoanApplicationResult register(@RequestBody LoanApplicationRequest loanRequest){
        return loanApplicationFacade.register(loanRequest);
    }

    @GetMapping("/{loanNumber}")
    public LoanApplicationView getByNumber(@PathVariable("loanNumber") String loanNumber){
        return loanApplicationFacade.getByNumber(loanNumber);
    }
}
