package org.springdemo.bookmytrip.mapper.request;

import org.springdemo.bookmytrip.dto.request.BookingRequestDTO;
import org.springdemo.bookmytrip.model.Booking;
import org.springdemo.bookmytrip.model.Customer;
import org.springdemo.bookmytrip.model.TripPackage;

public class BookingRequestMapper {

    private BookingRequestMapper(){}

    public static Booking toEntity(BookingRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Booking booking = new Booking();

        booking.setId(dto.getId());

        booking.setBookingDate(dto.getBookingDate());

        Customer customer = new Customer();

        customer.setId(dto.getCustomerId());

        booking.setCustomer(customer);

        TripPackage tripPackage = new TripPackage();

        tripPackage.setId(dto.getTravelPackageId());

        booking.setTripPackage(tripPackage);

        return booking;
    }
}