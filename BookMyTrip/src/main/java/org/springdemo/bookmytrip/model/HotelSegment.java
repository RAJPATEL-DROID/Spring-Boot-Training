package org.springdemo.bookmytrip.model;

import jakarta.persistence.*;

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

    private String hotelName;
    private String address;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public HotelSegment(Itinerary itinerary, SegmentType segmentType, String name, String address, Location location, LocalDate checkinDate, LocalDate checkoutDate){
        super(segmentType,itinerary);

        this.hotelName = name;
        this.address = address;
        this.location = location;
        this.checkInDate = checkinDate;
        this.checkOutDate = checkoutDate;
    }

}
