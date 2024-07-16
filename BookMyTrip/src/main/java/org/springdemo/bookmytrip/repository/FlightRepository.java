package org.springdemo.bookmytrip.repository;

import org.springdemo.bookmytrip.model.FlightSegment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<FlightSegment,Long> {
}
