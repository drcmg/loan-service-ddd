package com.asc.loanservice.api;

import com.asc.loanservice.contracts.LoanApplicationView;
import com.asc.loanservice.contracts.LoanApplicationRequest;
import com.asc.loanservice.contracts.LoanApplicationResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loans")
public class LoanApplicationController {

    @PostMapping
    public LoanApplicationResult register(@RequestBody LoanApplicationRequest loanRequest){
        //TODO: implement
        return null;
    }

    @GetMapping("/{loanNumber}")
    public LoanApplicationView getByNumber(@PathVariable("loanNumber") String loanNumber){
        //TODO: implement
        return null;
    }
}
