package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.Status;
import com.examly.springapp.model.Loan;
import com.examly.springapp.service.LoanService;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    
    @Autowired
    private LoanService loanService;
    
    @GetMapping
    public List<Loan> getLoanByAllId(){
        return loanService.getLoanByAllId();
    }
    
    @GetMapping("/{loanId}")
    public Loan getLoanById(@PathVariable Long loanId){
        return loanService.getLoanById(loanId);
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<?> getLoanBystatus(@PathVariable Status status){
        List<Loan> l=loanService.getLoanBystatus(status);
        if(l.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No loans found with status: REJECTED");
        }
        return ResponseEntity.ok(l);
    }

    @PostMapping
    public ResponseEntity<Loan> addLoan(@RequestBody Loan l){
        Loan s=loanService.addLoan(l);
        return ResponseEntity.status(HttpStatus.CREATED).body(s);
    }
    
    @PutMapping("/{loanId}")
    public ResponseEntity<Loan> putLoan(@PathVariable Long loanId,@RequestBody Loan l){
        Loan updated=loanService.putLoan(loanId,l);
        return ResponseEntity.ok(updated);
    }
}