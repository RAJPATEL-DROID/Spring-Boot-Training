package org.springdemo.bookmytrip.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationRequestDTO {

    @NotNull(message = "City Name is required")
    private String city;

    @NotNull(message = "Country name is required")
    private String country;

    @NotNull(message = "Airport Code is required")
    private String airportCode;

}
