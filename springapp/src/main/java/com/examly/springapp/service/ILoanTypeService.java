package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.LoanType;

public interface ILoanTypeService {
    List<LoanType> getLoanTypeByAllId();
    LoanType addLoanType(LoanType l);
    LoanType putLoanType(Long loanTypeId, LoanType l);
}
