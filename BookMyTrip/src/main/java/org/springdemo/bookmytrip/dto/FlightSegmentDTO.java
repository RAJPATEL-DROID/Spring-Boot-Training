package org.springdemo.bookmytrip.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightSegmentDTO extends TripSegmentDTO {

    private String flightNumber;
    private LocationDTO departureLocation;
    private LocationDTO arrivalLocation;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
}