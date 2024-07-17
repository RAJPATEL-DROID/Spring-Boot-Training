package org.springdemo.bookmytrip.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springdemo.bookmytrip.enums.SegmentType;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelSegmentResponseDTO{
    private Long id;
    private SegmentType segmentType = SegmentType.HOTEL;
    private String hotelName;
    private String address;
    private Long locationId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
