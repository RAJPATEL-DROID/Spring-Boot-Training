package org.springdemo.bookmytrip.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springdemo.bookmytrip.enums.SegmentType;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightSegmentResponseDTO {

    private Long id;

    private SegmentType segmentType = SegmentType.FLIGHT;

    private String flightNumber;

    private Long departureLocationId;

    private Long arrivalLocationId;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;
}