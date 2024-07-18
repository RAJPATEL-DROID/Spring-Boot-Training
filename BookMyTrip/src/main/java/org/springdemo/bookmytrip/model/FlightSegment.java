package org.springdemo.bookmytrip.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "flight_segment")
public class FlightSegment extends TripSegment {

    @NotBlank(message = "Flight Number can't be blank")
    private String flightNumber;

    @ManyToOne
    @NotNull(message = "Departure Location is Required")
    @JoinColumn(name = "departureLocation_id")
    private Location departureLocation;

    @ManyToOne
    @NotNull(message = "Arrival Location is Required")
    @JoinColumn(name = "arrival_location_id")
    private Location arrivalLocation;

    @NotNull(message = "Departure Time is Required")
    private LocalDateTime departureTime;

    @NotNull(message = "Arrival Time is required")
    private LocalDateTime arrivalTime;

}
