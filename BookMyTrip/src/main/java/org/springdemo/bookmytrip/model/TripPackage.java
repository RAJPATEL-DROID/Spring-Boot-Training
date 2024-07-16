package org.springdemo.bookmytrip.model;

import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trip_package")
public class TripPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private BigDecimal price;

    @OneToMany(mappedBy = "tripPackage", cascade = CascadeType.ALL)
    private List<Itinerary> itineraries = new ArrayList<>();

    @OneToMany(mappedBy = "tripPackage", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

}