package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.Status;
import com.examly.springapp.model.Loan;

public interface ILoanService {
    List<Loan> getLoanByAllId();
    Loan getLoanById(Long loanId);
    List<Loan> getLoanBystatus(Status status);
    Loan addLoan(Loan l);
    Loan putLoan(Long loanId, Loan l);
}
