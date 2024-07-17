package org.springdemo.bookmytrip.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String country;
    private String airportCode;

    public Location(String city,String country,String airportCode){
        this.city = city;
        this.country = country;
        this.airportCode = airportCode;
    }
}
