package org.springdemo.bookmytrip.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "itineraries")
public class Itinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name="trip_package_id")
    private TripPackage tripPackage;

    @OneToMany(mappedBy = "itinerary", cascade = CascadeType.ALL)
    private List<TripSegment> tripSegments = new ArrayList<>();

}
