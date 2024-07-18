package org.springdemo.bookmytrip.controller;

import jakarta.validation.Valid;
import org.springdemo.bookmytrip.dto.request.BookingRequestDTO;
import org.springdemo.bookmytrip.dto.response.BookingResponseDTO;
import org.springdemo.bookmytrip.mapper.request.BookingRequestMapper;
import org.springdemo.bookmytrip.mapper.response.BookingResponseMapper;
import org.springdemo.bookmytrip.model.Booking;
import org.springdemo.bookmytrip.service.BookingService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    BookingService bookingService;

    public BookingController(BookingService bookingService)
    {

        this.bookingService = bookingService;

    }

    @GetMapping
    public ResponseEntity<List<BookingResponseDTO>> getBookings(){

        List<Booking> bookingList = bookingService.getAllBookings();

        List<BookingResponseDTO> bookingResponseDTOS=  bookingList.stream().map(BookingResponseMapper::toDTO).toList();

        return ResponseEntity.ok(bookingResponseDTOS);

    }

    @GetMapping
    public ResponseEntity<List<BookingResponseDTO>> getBookingByDateRange(@RequestParam("start")
                                                                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime startDate,
                                                                          @RequestParam("start")
                                                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)  LocalDateTime endDate){
        List<Booking> bookingList = bookingService.getBookingsByDateRange(startDate,endDate);

        List<BookingResponseDTO> bookingResponseDTOS = bookingList.stream().map(BookingResponseMapper::toDTO).toList();

        return ResponseEntity.ok(bookingResponseDTOS);

    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingResponseDTO> updateBooking(@PathVariable Long id,@Valid @RequestBody BookingRequestDTO bookingRequestDTO){
        Booking booking = BookingRequestMapper.toEntity(bookingRequestDTO);

        Booking updateBooking  = bookingService.updateBooking(id,booking);

        BookingResponseDTO bookingResponseDTO = BookingResponseMapper.toDTO(updateBooking);

        return ResponseEntity.ok(bookingResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id){

        bookingService.deleteBooking(id);

        return ResponseEntity.noContent().build();

    }

}
