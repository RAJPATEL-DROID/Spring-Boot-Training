package org.springdemo.bookmytrip.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItineraryRequestDTO {

    @NotNull(message = "Travel Package ID is required")
    private Long travelPackageId;

    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    private LocalDate endDate;
//
//    @NotNull(message = "Trip Segments are Required")
//    private List<TripSegmentDTO> tripSegments;
}
