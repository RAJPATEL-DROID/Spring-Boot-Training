package org.springdemo.bookmytrip.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id",nullable = false)
    Long id;

    @Column(name = "city",nullable = false)
    String city;

    @Column(name = "country",nullable = false)
    String country;

    @Column(name = "airport_code",nullable = false)
    String airportCode;

    public Location(String city,String country,String airportCode){
        this.city = city;
        this.country = country;
        this.airportCode = airportCode;
    }
}
