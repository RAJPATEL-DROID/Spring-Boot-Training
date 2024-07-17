package org.springdemo.bookmytrip.service;


import org.springdemo.bookmytrip.dto.request.CustomerRequestDTO;
import org.springdemo.bookmytrip.dto.response.CustomerResponseDTO;
import org.springdemo.bookmytrip.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer getCustomerById(Long id);
    Customer updateCustomer(Long id, Customer customer);
    void deleteCustomer(Long id);
    List<Customer> getAllCustomers();
}