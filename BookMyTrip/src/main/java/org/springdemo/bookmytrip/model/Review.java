package org.springdemo.bookmytrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "trip_package_id")
    private TripPackage tripPackage;

    private int rating;
    private String comment;
    private LocalDateTime reviewDate;

    public Review(int rating, String comment, TripPackage tripPackage, Customer customer) {
        this.rating = rating;
        this.comment = comment;
        this.tripPackage = tripPackage;
        this.customer = customer;
    }

}
