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

import com.examly.springapp.model.LoanType;
import com.examly.springapp.service.LoanTypeService;

@RestController
@RequestMapping("/api/loantypes")
public class LoanTypeController {
    @Autowired
    private LoanTypeService loanTypeService;

    @GetMapping
    public List<LoanType> getLoanTypeByAllId(){
        return loanTypeService.getLoanTypeByAllId();
    }

    @PostMapping
    public ResponseEntity<LoanType> addLoanType(@RequestBody LoanType l){
        LoanType s=loanTypeService.addLoanType(l);
        return ResponseEntity.status(HttpStatus.CREATED).body(s);
    }
    
    @PutMapping("/{loanTypeId}")
    public ResponseEntity<LoanType> putLoanType(@PathVariable Long loanTypeId,@RequestBody LoanType l){
        LoanType updated=loanTypeService.putLoanType(loanTypeId,l);
        return ResponseEntity.ok(updated);
    }
}