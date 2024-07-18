package org.springdemo.bookmytrip.mapper.response;

import org.springdemo.bookmytrip.dto.request.BookingRequestDTO;
import org.springdemo.bookmytrip.dto.response.BookingResponseDTO;
import org.springdemo.bookmytrip.model.Booking;
import org.springdemo.bookmytrip.model.Customer;
import org.springdemo.bookmytrip.model.TripPackage;

public class BookingResponseMapper {

    private BookingResponseMapper(){}

    public static BookingResponseDTO toDTO(Booking booking) {
        if (booking == null) {
            return null;
        }

        BookingResponseDTO dto = new BookingResponseDTO();
        dto.setId(booking.getId());
        dto.setCustomer(CustomerResponseMapper.toDTO(booking.getCustomer()));
        dto.setTripPackage(TripPackageResponseMapper.toDTO(booking.getTripPackage()));
        dto.setBookingDate(booking.getBookingDate());

        return dto;
    }

    public static Booking toEntity(BookingResponseDTO dto) {
        if (dto == null) {
            return null;
        }

        Booking booking = new Booking();
        booking.setId(dto.getId());
        booking.setBookingDate(dto.getBookingDate());
        booking.setCustomer(CustomerResponseMapper.toEntity(dto.getCustomer()));
        booking.setTripPackage(TripPackageResponseMapper.toEntity(dto.getTripPackage()));


        return booking;
    }
}