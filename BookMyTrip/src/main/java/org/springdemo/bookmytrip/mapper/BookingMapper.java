package org.springdemo.bookmytrip.mapper;

import org.springdemo.bookmytrip.model.Booking;
import org.springdemo.bookmytrip.model.Customer;
import org.springdemo.bookmytrip.model.TripPackage;

public class BookingMapper {

    public static BookingDTO toDTO(Booking booking) {
        if (booking == null) {
            return null;
        }

        BookingDTO dto = new BookingDTO();
        dto.setId(booking.getId());
        dto.setCustomerId(booking.getCustomer() != null ? booking.getCustomer().getId() : null);
        dto.setTravelPackageId(booking.getTripPackage() != null ? booking.getTripPackage().getId() : null);
        dto.setBookingDate(booking.getBookingDate());
        dto.setStatus(booking.getStatus());

        return dto;
    }

    public static Booking toEntity(BookingDTO dto) {
        if (dto == null) {
            return null;
        }

        Booking booking = new Booking();
        booking.setId(dto.getId());
        booking.setBookingDate(dto.getBookingDate());
        booking.setStatus(dto.getStatus());

        // Set customer and tripPackage references
        if (dto.getCustomerId() != null) {
            Customer customer = new Customer();
            customer.setId(dto.getCustomerId());
            booking.setCustomer(customer);
        }

        if (dto.getTravelPackageId() != null) {
            TripPackage tripPackage = new TripPackage();
            tripPackage.setId(dto.getTravelPackageId());
            booking.setTripPackage(tripPackage);
        }

        return booking;
    }
}