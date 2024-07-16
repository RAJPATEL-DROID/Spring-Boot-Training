package org.springdemo.bookmytrip.service;

import org.springdemo.bookmytrip.dto.TripPackageDTO;
import org.springdemo.bookmytrip.model.TripPackage;
import org.springdemo.bookmytrip.repository.TripPackageRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public interface TripPackageService {
    
    TripPackage createTripPackage(TripPackageDTO travelPackageDTO);
    TripPackage getTripPackageById(Long id);
    TripPackage updateTripPackage(Long id, TripPackageDTO travelPackageDTO);
    void deleteTripPackage(Long id);

    List<TripPackage> getTripPackagesByMaxPrice(BigDecimal maxPrice);
    
    List<TripPackageDTO> getAllTripPackage();
    List<TripPackage> getPackagesWithinDateRange(LocalDate startDate, LocalDate endDate);
    List<TripPackage> getPackagesByPriceRangeAndLocation(BigDecimal minPrice, BigDecimal maxPrice, String location);
}
