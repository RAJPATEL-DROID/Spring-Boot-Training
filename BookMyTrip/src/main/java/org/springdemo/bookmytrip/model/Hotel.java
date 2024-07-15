package org.springdemo.bookmytrip.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "hotel_segment")
public class Hotel extends TripSegment {

    @Column(name = "name",nullable = false)
    String name;

    @Column(name = "address",nullable = false)
    String address;

    @OneToOne
    @JoinColumn(name = "location")
    Location location;

    @Column(name = "check_in_time")
    LocalDate checkinDate;

    @Column(name = "check_out_time")
    LocalDate checkoutDate;

    public Hotel(Itinerary itinerary, SegmentType segmentType, String name,String address,Location location,LocalDate checkinDate,LocalDate checkoutDate){
        super(segmentType,itinerary);

        this.name = name;
        this.address = address;
        this.location = location;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
    }

}
