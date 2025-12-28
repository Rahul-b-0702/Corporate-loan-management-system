package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.LoanType;
import com.examly.springapp.repository.LoanTypeRepo;

@Service
public class LoanTypeService {
    @Autowired
    private LoanTypeRepo loanTypeRepo;

    public List<LoanType> getLoanTypeByAllId(){
        return loanTypeRepo.findAll();
    }

    public LoanType addLoanType(LoanType l){
        return loanTypeRepo.save(l);
    }

    public LoanType putLoanType(Long loanTypeId,LoanType l){
        LoanType existing=loanTypeRepo.findById(loanTypeId).orElse(null);
        if(existing==null){
            return null;
        }else{
            existing.setTypeName(l.getTypeName());
            existing.setInterestRate(l.getInterestRate());
            existing.setDescription(l.getDescription());
            return loanTypeRepo.save(existing);
        }
    }
}