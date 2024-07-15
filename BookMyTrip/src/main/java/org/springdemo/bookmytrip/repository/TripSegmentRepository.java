package org.springdemo.bookmytrip.repository;

import org.springdemo.bookmytrip.model.TripSegment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripSegmentRepository extends JpaRepository<TripSegment,Long> {
}
