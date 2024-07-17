package org.springdemo.bookmytrip.service;

import org.springdemo.bookmytrip.dto.request.BookingRequestDTO;
import org.springdemo.bookmytrip.enums.BookingStatus;
import org.springdemo.bookmytrip.model.Booking;
import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {

    Booking createBooking(BookingRequestDTO bookingRequestDTO);

    Booking getBookingById(Long id);

    Booking updateBooking(Long id, BookingRequestDTO bookingRequestDTO);

    void deleteBooking(Long id);

    List<Booking> getAllBookings();

    List<Booking> getBookingsByCustomerId(Long customerId);

    List<Booking> getBookingsWithDetailsForCustomer(Long customerId);

    List<Booking> getBookingsByDateRangeAndStatus(LocalDateTime startDate, LocalDateTime endDate, BookingStatus status);
}
