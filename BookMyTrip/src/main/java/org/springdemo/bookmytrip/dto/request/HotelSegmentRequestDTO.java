package org.springdemo.bookmytrip.dto.request;

import jakarta.validation.constraints.NotNull;
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

    private SegmentType segmentType = SegmentType.HOTEL;

    @NotNull
    private Long itineraryId;

    @NotNull
    private String hotelName;

    @NotNull
    private String address;

    @NotNull
    private Long locationId;

    @NotNull
    private LocalDate checkInDate;

    @NotNull
    private LocalDate checkOutDate;

}
