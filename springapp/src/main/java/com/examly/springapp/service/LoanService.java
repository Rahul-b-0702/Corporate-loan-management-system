package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.Status;
import com.examly.springapp.exception.ResourceNotFoundException;
import com.examly.springapp.model.Loan;
import com.examly.springapp.repository.LoanRepo;

@Service
public class LoanService implements ILoanService {
    
    @Autowired
    private LoanRepo loanRepo;

    public List<Loan> getLoanByAllId(){
        return loanRepo.findAll();
    }

    public Loan getLoanById(Long loanId){
        return loanRepo.findById(loanId).orElseThrow(() -> new ResourceNotFoundException(
            "Loan not found with id: " + loanId
        ));
    }

    public List<Loan> getLoanBystatus(Status status){
        return loanRepo.findAllByStatus(status);
    }

    public Loan addLoan(Loan l){
        return loanRepo.save(l);
    }

    public Loan putLoan(Long loanId,Loan l){
        Loan existing=loanRepo.findById(loanId).orElseThrow(() -> new ResourceNotFoundException(
            "Loan not found with id: " + loanId
        ));
        existing.setLoanAmount(l.getLoanAmount());
        existing.setInterestRate(l.getInterestRate());
        existing.setTenureMonths(l.getTenureMonths());
        existing.setStatus(l.getStatus());
        existing.setCustomerId(l.getCustomerId());
        existing.setLoanTypeId(l.getLoanTypeId());
        return loanRepo.save(existing);
    }
}