package org.springdemo.bookmytrip.mapper.request;

import org.springdemo.bookmytrip.dto.request.CustomerRequestDTO;
import org.springdemo.bookmytrip.dto.response.CustomerResponseDTO;
import org.springdemo.bookmytrip.model.Customer;

import java.util.ArrayList;

public class CustomerRequestMapper {

    public static Customer toEntity(CustomerRequestDTO dto) {
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