package org.springdemo.bookmytrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Itinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "starting_date",nullable = false)
    LocalDate startDate;

    @Column(name = "last_date",nullable = false)
    LocalDate lastDate;

    @ManyToOne
    @JoinColumn(name="trip_package_id")
    TripPackage tripPackage;

    @OneToMany(mappedBy = "itinerary", cascade = CascadeType.ALL)
    List<TripSegment> tripSegments = new ArrayList<>();


}
