package org.springdemo.bookmytrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name",nullable = false)
    String name;

    @Column(name = "email_id",nullable = false)
    String email;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<Booking> bookings;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<Review> reviews;
}
