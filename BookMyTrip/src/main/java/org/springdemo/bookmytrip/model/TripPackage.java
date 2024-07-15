package org.springdemo.bookmytrip.model;

import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TripPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="trip_name",nullable = false)
    String tripName;

    @Column(name = "description",nullable = false)
    String description;

    @Column(name = "price",nullable = false)
    BigDecimal price;

    @OneToMany(mappedBy = "tripPackage", cascade = CascadeType.ALL)
    private List<Itinerary> itineraries;

    @OneToMany(mappedBy = "tripPackage")
    private List<Review> reviews;

//    @Override
//    public String toString() {
//        return "TripPackage{" +
//                "id=" + id +
//                ", tripName='" + tripName + '\'' +
//                ", description='" + description + '\'' +
//                ", price=" + price +
//                '}';
//    }
}
