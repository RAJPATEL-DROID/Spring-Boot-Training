package org.springdemo.bookmytrip.service;


import org.springdemo.bookmytrip.dto.CustomerDTO;
import org.springdemo.bookmytrip.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(CustomerDTO customerDTO);
    Customer getCustomerById(Long id);
    Customer updateCustomer(Long id, CustomerDTO customerDTO);
    void deleteCustomer(Long id);
    List<Customer> getAllCustomers();
}