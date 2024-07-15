package org.springdemo.bookmytrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment", nullable = false)
    private String comment;

    @Column(name = "rating", nullable = false, precision = 2, scale = 1)
    private BigDecimal rating;

    @ManyToOne
    @JoinColumn(name = "trip_package_id")
    private TripPackage tripPackage;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Review(BigDecimal rating, String comment, TripPackage tripPackage, Customer customer) {
        this.rating = rating;
        this.comment = comment;
        this.tripPackage = tripPackage;
        this.customer = customer;
    }

}
