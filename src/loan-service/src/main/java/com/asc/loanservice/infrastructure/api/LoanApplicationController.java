package com.asc.loanservice.infrastructure.api;

import com.asc.loanservice.infrastructure.api.contract.LoanApplicationView;
import com.asc.loanservice.infrastructure.api.contract.LoanApplicationRequest;
import com.asc.loanservice.infrastructure.api.contract.LoanApplicationResult;
import com.asc.loanservice.domain.loan.application.LoanApplicationFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

@AllArgsConstructor
@RestController
@RequestMapping("/api/loans")
class LoanApplicationController {

    private final LoanApplicationFacade loanApplicationFacade;

    @PostMapping
    public ResponseEntity<LoanApplicationResult> register(@RequestBody @Valid @NotNull LoanApplicationRequest loanRequest){
        LoanApplicationResult register = loanApplicationFacade.register(loanRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(register);
    }

    @GetMapping("/{loanNumber}")
    public ResponseEntity<LoanApplicationView> getByNumber(@PathVariable("loanNumber") String loanNumber){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(loanApplicationFacade.getByNumber(loanNumber));
    }
}
