package org.springdemo.bookmytrip.repository;

import org.springdemo.bookmytrip.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight,Long> {
}
