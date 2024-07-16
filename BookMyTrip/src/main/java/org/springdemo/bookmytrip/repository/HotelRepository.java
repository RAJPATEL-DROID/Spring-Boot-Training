package org.springdemo.bookmytrip.repository;

import org.springdemo.bookmytrip.model.HotelSegment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<HotelSegment,Long> {
}
