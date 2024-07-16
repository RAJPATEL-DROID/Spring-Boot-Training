package org.springdemo.bookmytrip.repository;

import org.springdemo.bookmytrip.model.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary,Long> {
}
