package com.examly.springapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Customer;
  
@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long>{
    Optional<Customer> findByEmail(String email);
    List<Customer> findByCreditScore(Double creditScore);
}
