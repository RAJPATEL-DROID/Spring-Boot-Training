package org.springdemo.bookmytrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "status",nullable = false)
    String status;

    @Column(name = "booking_date", nullable = false)
    LocalDateTime bookingDate;

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "trip_package_id",nullable = false)
    TripPackage tripPackage;

    @OneToOne
    @JoinColumn(name = "payment", nullable = false)
    Payment payment;

}

