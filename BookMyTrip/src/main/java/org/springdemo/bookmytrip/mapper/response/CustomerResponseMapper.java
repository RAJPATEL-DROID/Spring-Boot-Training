package org.springdemo.bookmytrip.mapper.response;

import org.springdemo.bookmytrip.dto.response.CustomerResponseDTO;
import org.springdemo.bookmytrip.model.Customer;

import java.util.ArrayList;

public class CustomerResponseMapper {

    public static CustomerResponseDTO toDTO(Customer customer) {
        if (customer == null) {
            return null;
        }

        CustomerResponseDTO dto = new CustomerResponseDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());

        dto.setBookings(customer.getBookings().stream().map(BookingResponseMapper::toDTO).toList());

        dto.setReviews(customer.getReviews().stream().map(ReviewResponseMapper::toDTO).toList());
        return dto;
    }

    public static Customer toEntity(CustomerResponseDTO dto) {
        if (dto == null) {
            return null;
        }

        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());

        // Initialize empty lists for bookings and reviews
        customer.setBookings(new ArrayList<>());
        customer.setReviews(new ArrayList<>());

        return customer;
    }
}