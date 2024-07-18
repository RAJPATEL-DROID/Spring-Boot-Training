package org.springdemo.bookmytrip.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class FlightSegmentRequestDTO{

    private SegmentType segmentType = SegmentType.FLIGHT;

    @NotNull
    private Long itineraryId;

    @NotNull
    private String flightNumber;

    @NotNull
    private Long departureLocationId;

    @NotNull
    private Long arrivalLocationId;

    @NotNull
    private LocalDateTime departureTime;

    @NotNull
    private LocalDateTime arrivalTime;
}