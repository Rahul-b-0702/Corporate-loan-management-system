package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.Status;
import com.examly.springapp.model.Loan;
import com.examly.springapp.repository.LoanRepo;

@Service
public class LoanService {
    
    @Autowired
    private LoanRepo loanRepo;

    public List<Loan> getLoanByAllId(){
        return loanRepo.findAll();
    }

    public Loan getLoanById(Long loanId){
        return loanRepo.findById(loanId).orElse(null);
    }

    public List<Loan> getLoanBystatus(Status status){
        return loanRepo.findAllByStatus(status);
    }

    public Loan addLoan(Loan l){
        return loanRepo.save(l);
    }

    public Loan putLoan(Long loanId,Loan l){
        Loan existing=loanRepo.findById(loanId).orElse(null);
        if(existing==null){
            return null;
        }else{
            existing.setLoanAmount(l.getLoanAmount());
            existing.setInterestRate(l.getInterestRate());
            existing.setTenureMonths(l.getTenureMonths());
            existing.setStatus(l.getStatus());
            existing.setCustomerId(l.getCustomerId());
            existing.setLoanTyepId(l.getLoanTyepId());
            return loanRepo.save(existing);
        }
    }
}