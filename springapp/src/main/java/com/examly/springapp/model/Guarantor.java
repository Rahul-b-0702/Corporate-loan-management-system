package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
public class Guarantor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long GuarantorId;
    private String GuarantorName;
    private String email;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name="load_id")
    private Loan loanId; //FK
}
