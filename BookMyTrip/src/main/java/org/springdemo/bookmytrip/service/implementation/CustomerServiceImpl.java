package org.springdemo.bookmytrip.service.implementation;


import org.springdemo.bookmytrip.exception.ResourceNotFoundException;
import org.springdemo.bookmytrip.model.Customer;
import org.springdemo.bookmytrip.repository.CustomerRepository;
import org.springdemo.bookmytrip.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public Customer createCustomer(Customer customerRequest) {

        return customerRepository.save(customerRequest);

    }

    @Override
    @Transactional
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Customer found with id: " + id));

    }

    @Override
    @Transactional
    public Customer updateCustomer(Long id, Customer customerRequest) {

        Customer customer =  getCustomerById(id);

        if(customerRequest.getName() != null) {
            customer.setName(customerRequest.getName());
        }
        if(customerRequest.getEmail() != null){
            customer.setEmail(customerRequest.getEmail());
        }


        return customerRepository.save(customer);
    }

    @Override
    @Transactional
    public void deleteCustomer(Long id) {
        Customer customer =  getCustomerById(id);

        customerRepository.delete(customer);
    }

    @Override
    @Transactional
    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();

    }
}