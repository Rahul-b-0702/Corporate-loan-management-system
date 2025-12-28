package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Customer;
import com.examly.springapp.service.CustomerService;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping
    public List<Customer> getCustomerAll(){
        return service.getCustomerAll();
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<?> getCustomerByEmail(@PathVariable String email){
        Customer l=service.getCustomerByEmail(email);
        if(l==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found with email: "+email);
        }
        return ResponseEntity.ok(l);
    }
    
    
    @GetMapping("/creditScore/{creditScore}")
    public ResponseEntity<?> getCustomerByCreditScore(@PathVariable Double creditScore){
        List<Customer> l=service.getCustomerByCreditScore(creditScore);
        if(l.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No customers found with credit score >= "+creditScore);
        }
        return ResponseEntity.ok(l);
    }
    
    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId){
        return service.getCustomerById(customerId);
    }
    
    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer c){
        Customer s=service.addCustomer(c);
        return ResponseEntity.status(HttpStatus.CREATED).body(s);
    }
        
    @PutMapping("/{customerId}")
    public Customer putCustomer(@PathVariable Long customerId,@RequestBody Customer c){
        return service.putCustomer(customerId,c);
    }
    
    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId){
        service.deleteCustomer(customerId);
    }

    //Pagination

    @GetMapping("page/{page}/{size}")
    public Page<Customer> getCustomerByPage(@PathVariable int page,@PathVariable int size){
        return service.getCustomerByPage(page,size);
    }
}