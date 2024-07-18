package org.springdemo.bookmytrip.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItineraryResponseDTO {

    Long id;

    private TripPackageResponseDTO tripPackage;

    private LocalDate startDate;

    private LocalDate endDate;;
}
