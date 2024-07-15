package org.springdemo.bookmytrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "trip_segment")
public abstract class TripSegment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "segment_type",nullable = false)
    SegmentType segmentType;

    @ManyToOne
    @JoinColumn(name = "itinerary_id")
    Itinerary itinerary;

    public TripSegment(SegmentType segmentType,Itinerary itinerary){
        this.segmentType = segmentType;
        this.itinerary = itinerary;
    }

}
