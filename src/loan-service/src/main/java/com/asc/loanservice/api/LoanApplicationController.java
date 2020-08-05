package com.asc.loanservice.api;

import com.asc.loanservice.contracts.LoanApplicationDataDto;
import com.asc.loanservice.contracts.LoanApplicationRequestDto;
import com.asc.loanservice.contracts.LoanApplicationResultDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loans")
public class LoanApplicationController {

    @PostMapping
    public LoanApplicationResultDto register(@RequestBody LoanApplicationRequestDto loanRequest){
        //TODO: implement
        return null;
    }

    @GetMapping("/{loanNumber}")
    public LoanApplicationDataDto getByNumber(@PathVariable("loanNumber") String loanNumber){
        //TODO: implement
        return null;
    }
}
