package org.springdemo.bookmytrip.repository;

import org.springdemo.bookmytrip.model.TripPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TripPackageRepository extends JpaRepository<TripPackage,Long> {
    List<TripPackage> findByPriceLessThanEqual(BigDecimal maxPrice);

////    @Query("SELECT tp FROM TripPackage tp JOIN Itinerary.tripPackage WHERE Itinerary.startDate >= :startDate AND Itinerary.endDate <= :endDate")
//    List<TripPackage> findPackagesWithinDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
// itineraries.startDate >= :startDate AND itineraries.endDate <= :endDate