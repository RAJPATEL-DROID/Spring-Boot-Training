package org.springdemo.bookmytrip.service;

import org.springdemo.bookmytrip.enums.BookingStatus;
import org.springdemo.bookmytrip.model.Booking;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {

    Booking createBooking(Booking booking);

    Booking getBookingById(Long id);

    Booking updateBooking(Long id, Booking booking);

    void deleteBooking(Long bookingId);

    List<Booking> getAllBookings();

    List<Booking> getBookingsByCustomerId(Long customerId);
//
//    List<Booking> getBookingsWithDetailsForCustomer(Long customerId);

    List<Booking> getBookingsByDateRange(LocalDateTime startDate, LocalDateTime endDate);
}
