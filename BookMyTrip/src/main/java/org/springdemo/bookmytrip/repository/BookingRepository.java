package org.springdemo.bookmytrip.repository;

import org.springdemo.bookmytrip.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
