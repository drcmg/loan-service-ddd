package com.asc.loanservice.domain.loan.application.north;

import com.asc.loanservice.domain.loan.application.LoanApplicationAggregate;
import com.asc.loanservice.domain.loan.application.contract.LoanApplicationRequest;
import com.asc.loanservice.domain.loan.application.contract.LoanApplicationResult;
import com.asc.loanservice.domain.loan.application.contract.LoanApplicationView;
import com.asc.loanservice.constant.ValidationOrder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;


@Validated(ValidationOrder.class)
@AllArgsConstructor
@RequestMapping("/api/loans")
@RestController
class LoanApplicationController {

    private final LoanApplicationAggregate loanApplicationAggregate;

    @PostMapping
    public ResponseEntity<LoanApplicationResult> register(
                    @RequestBody @Valid @NotNull(groups = Default.class) LoanApplicationRequest loanRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(loanApplicationAggregate.register(loanRequest));
    }

    @GetMapping("/{loanNumber}")
    public ResponseEntity<LoanApplicationView> getByNumber(@PathVariable("loanNumber") String loanNumber){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(loanApplicationAggregate.getByNumber(loanNumber));
    }
}
