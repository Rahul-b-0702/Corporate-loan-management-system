package com.examly.springapp.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.examly.springapp.model.Customer;

public interface ICustomerService {
    List<Customer> getCustomerAll();
    Customer getCustomerById(Long customerId);
    Customer getCustomerByEmail(String email);
    List<Customer> getCustomerByCreditScore(Double creditScore);
    Customer addCustomer(Customer c);
    Customer putCustomer(Long customerId, Customer c);
    void deleteCustomer(Long customerId);
    Page<Customer> getCustomerByPage(int page, int size);
}
