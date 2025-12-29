package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.ResourceNotFoundException;
import com.examly.springapp.model.Customer;
import com.examly.springapp.repository.CustomerRepo;

@Service
public class CustomerService implements ICustomerService {
  
    @Autowired
    private CustomerRepo customerRepo;
    
    public List<Customer> getCustomerAll(){
        return customerRepo.findAll();
    }
    
    public Customer getCustomerById(Long customerId){
        return customerRepo.findById(customerId).orElseThrow(() -> new ResourceNotFoundException(
            "Customer not found with id: " + customerId
        ));
    }

    public Customer getCustomerByEmail(String email){
        return customerRepo.findByEmail(email).orElse(null);
    }
    public List<Customer> getCustomerByCreditScore(Double creditScore){
        return customerRepo.findByCreditScore(creditScore);
    }
    
    public Customer addCustomer(Customer c){
        return customerRepo.save(c);
    }
    
    public Customer putCustomer(Long customerId,Customer c){
        Customer existing=customerRepo.findById(customerId).orElseThrow(() -> new ResourceNotFoundException(
            "Customer not found with id: " + customerId
        ));
        existing.setCustomerName(c.getCustomerName());
        existing.setEmail(c.getEmail());
        existing.setPhoneNumber(c.getPhoneNumber());
        existing.setAddress(c.getAddress());
        existing.setCreditScore(c.getCreditScore());
        return customerRepo.save(existing);
    }
    
    public void deleteCustomer(Long customerId){
        customerRepo.deleteById(customerId);
    }
    
    public Page<Customer> getCustomerByPage(int page, int size){
        Pageable pageable=PageRequest.of(page,size);
        return customerRepo.findAll(pageable);
    } 
    
}