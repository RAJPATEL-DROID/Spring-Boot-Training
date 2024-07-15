package org.springdemo.bookmytrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "flight_segment")
public class Flight extends TripSegment {

    @Column(name = "flight_number",nullable = false)
    String flightNumber;

    @Column(name = "arrival_time",nullable = false)
    LocalDateTime arrivalTime;

    @Column(name = "departure_time",nullable = false)
    LocalDateTime departureTime;

    @OneToOne
    @JoinColumn(name = "arrival_location")
    Location arrivalLocation;

    @OneToOne
    @JoinColumn(name = "departure_location")
    Location departureLocation;

    public Flight(Itinerary itinerary, SegmentType segmentType, String flightNumber,LocalDateTime arrivalTime,LocalDateTime departureTime,Location arrivalLocation,Location departureLocation){
        super(segmentType,itinerary);

        this.flightNumber = flightNumber;
        this.arrivalLocation = arrivalLocation;
        this.departureLocation = departureLocation;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }


}
