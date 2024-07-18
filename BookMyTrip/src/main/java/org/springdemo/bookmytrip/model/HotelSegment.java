package org.springdemo.bookmytrip.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "hotel_segment")
public class HotelSegment extends TripSegment {

    @NotBlank(message = "HotelName is necessary")
    private String hotelName;

    @NotNull(message = "Address is necessary")
    private String address;

    @NotNull(message = "CheckInDate is necessary")
    private LocalDate checkInDate;

    @NotNull(message = "CheckOutDate is necessary")
    private LocalDate checkOutDate;

    @ManyToOne
    @NotNull(message = "Location Id is necessary")
    @JoinColumn(name = "location_id")
    private Location location;

}
