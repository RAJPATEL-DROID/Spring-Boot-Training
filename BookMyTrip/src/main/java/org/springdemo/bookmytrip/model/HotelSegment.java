package org.springdemo.bookmytrip.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springdemo.bookmytrip.enums.SegmentType;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "hotel_segment")
public class HotelSegment extends TripSegment {

    @NotBlank(message = "HotelName is necessary")
    private String hotelName;

    @NotNull(message = "Address is necessary")
    private String address;

    @NotNull(message = "CheckInDate is necessary")
    private LocalDate checkInDate;

    @NotNull(message = "CheckOutDate is necessary")
    private LocalDate checkOutDate;

    @NotNull(message = "Location Id is necessary")
    private Long locationId;

    public HotelSegment(Itinerary itinerary, SegmentType segmentType, String name, String address, Long location_id, LocalDate checkinDate, LocalDate checkoutDate){
        super(segmentType,itinerary);

        this.hotelName = name;
        this.address = address;
        this.locationId = location_id;
        this.checkInDate = checkinDate;
        this.checkOutDate = checkoutDate;
    }

}
