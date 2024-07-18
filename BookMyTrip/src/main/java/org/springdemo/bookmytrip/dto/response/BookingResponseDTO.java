package org.springdemo.bookmytrip.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springdemo.bookmytrip.enums.BookingStatus;
import jakarta.validation.constraints.NotNull;
import org.springdemo.bookmytrip.model.Customer;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BookingResponseDTO {
    private Long id;

    private CustomerResponseDTO customer;

    private TripPackageResponseDTO tripPackage;

    private LocalDateTime bookingDate;


}