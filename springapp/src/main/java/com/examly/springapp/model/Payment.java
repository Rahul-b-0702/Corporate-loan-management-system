package com.examly.springapp.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.examly.springapp.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentId;
    private Double amount;
    private String paymentDate;
    @ManyToOne
    @JoinColumn(name="load_id")
    private Loan loanId; //FK
}
