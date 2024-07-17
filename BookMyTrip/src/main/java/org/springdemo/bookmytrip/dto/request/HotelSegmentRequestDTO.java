package org.springdemo.bookmytrip.dto.request;

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
public class HotelSegmentRequestDTO{

    private Long id;
    private SegmentType segmentType = SegmentType.FLIGHT;
    private String hotelName;
    private String address;
    private Long locationId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

}
