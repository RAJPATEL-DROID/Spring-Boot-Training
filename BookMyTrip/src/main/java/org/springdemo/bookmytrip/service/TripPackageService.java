package org.springdemo.bookmytrip.service;

import org.springdemo.bookmytrip.model.TripPackage;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public interface TripPackageService {
    
    TripPackage createTripPackage(TripPackage travelPackageDTO);
    TripPackage getTripPackageById(Long id);
    TripPackage updateTripPackage(Long id, TripPackage travelPackageDTO);
    void deleteTripPackage(Long id);

    List<TripPackage> getTripPackagesByMaxPrice(BigDecimal maxPrice);
    
    List<TripPackage> getAllTripPackage();
    List<TripPackage> getPackagesWithinDateRange(LocalDate startDate, LocalDate endDate);
    List<TripPackage> getPackagesByPriceRangeAndLocation(BigDecimal minPrice, BigDecimal maxPrice, String location);
}
