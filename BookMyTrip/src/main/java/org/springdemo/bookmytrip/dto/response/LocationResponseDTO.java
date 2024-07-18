package org.springdemo.bookmytrip.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationResponseDTO {

    private Long id;

    @NotNull(message = "City Name is required")
    private String city;

    @NotNull(message = "Country name is required")
    private String country;

    @NotNull(message = "Airport Code is required")
    private String airportCode;

}
