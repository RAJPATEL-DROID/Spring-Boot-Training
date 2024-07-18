package org.springdemo.bookmytrip.repository;

import org.springdemo.bookmytrip.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByCustomerId(Long customerId);

//    @Query("SELECT b FROM Booking b JOIN FETCH b.customer c JOIN FETCH b.tripPackage tp WHERE c.id = :customerId")
//    List<Booking> findBookingsWithDetailsForCustomer(@Param("customerId") Long customerId);
}