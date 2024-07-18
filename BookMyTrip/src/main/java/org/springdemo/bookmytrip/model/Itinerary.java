package org.springdemo.bookmytrip.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Start Date can not be NULL")
    private LocalDate startDate;

    @NotNull(message = "End Date can not be NULL")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name="trip_package_id")
    @NotNull(message = "Trip Package can't be null")
    private TripPackage tripPackage;

    @ToString.Exclude
    @OneToMany(mappedBy = "itinerary", cascade = CascadeType.ALL)
    private List<TripSegment> tripSegments = new ArrayList<>();

}
