package org.springdemo.bookmytrip.repository;

import org.springdemo.bookmytrip.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
