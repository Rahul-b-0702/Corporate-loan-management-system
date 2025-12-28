package com.examly.springapp.model;

import com.examly.springapp.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long loanId;
    private Double loanAmount;
    private Double interestRate;
    private int tenureMonths;
    private Status status;

    @ManyToOne 
    @JoinColumn(name="customer_id")
    private Customer customerId; //FK
    
    @ManyToOne
    @JoinColumn(name="load_type")
    private LoanType loanTyepId; //FK
}
