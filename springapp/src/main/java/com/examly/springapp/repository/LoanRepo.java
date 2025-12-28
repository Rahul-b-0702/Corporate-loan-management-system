package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.Status;
import com.examly.springapp.model.Loan;

@Repository
public interface LoanRepo extends JpaRepository<Loan,Long>{
    List<Loan> findAllByStatus(Status status);
}
