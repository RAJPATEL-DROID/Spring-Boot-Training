package org.springdemo.bookmytrip.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springdemo.bookmytrip.enums.SegmentType;
import org.springdemo.bookmytrip.model.Location;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightSegmentResponseDTO {

    private Long id;

    private ItineraryResponseDTO itinerary;

    private SegmentType segmentType = SegmentType.FLIGHT;

    private String flightNumber;

    private Location departureLocation;

    private Location arrivalLocation;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;
}