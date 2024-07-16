package org.springdemo.bookmytrip.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelSegmentDTO extends TripSegmentDTO {

    private String hotelName;
    private String address;
    private LocationDTO location;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
