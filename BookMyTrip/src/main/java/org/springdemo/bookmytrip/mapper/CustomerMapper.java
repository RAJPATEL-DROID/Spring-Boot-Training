package org.springdemo.bookmytrip.mapper;

import org.springdemo.bookmytrip.dto.CustomerDTO;
import org.springdemo.bookmytrip.model.Customer;

import java.util.ArrayList;

public class CustomerMapper {

    public static CustomerDTO toDTO(Customer customer) {
        if (customer == null) {
            return null;
        }

        CustomerDTO dto = new CustomerDTO();
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());

        return dto;
    }

    public static Customer toEntity(CustomerDTO dto) {
        if (dto == null) {
            return null;
        }

        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());

        // Initialize empty lists for bookings and reviews
        customer.setBookings(new ArrayList<>());
        customer.setReviews(new ArrayList<>());

        return customer;
    }
}