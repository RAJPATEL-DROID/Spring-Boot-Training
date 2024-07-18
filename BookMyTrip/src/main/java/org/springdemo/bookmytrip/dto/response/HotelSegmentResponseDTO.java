package org.springdemo.bookmytrip.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springdemo.bookmytrip.enums.SegmentType;
import org.springdemo.bookmytrip.model.Location;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelSegmentResponseDTO{
    private Long id;

    private ItineraryResponseDTO itinerary;

    private SegmentType segmentType = SegmentType.HOTEL;

    private String hotelName;

    private String address;

    private Location location;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;
}

