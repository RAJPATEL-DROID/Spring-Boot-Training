package org.springdemo.bookmytrip.controller;

import org.springdemo.bookmytrip.dto.TripPackageDTO;
import org.springdemo.bookmytrip.model.TripPackage;
import org.springdemo.bookmytrip.service.TripPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/travel-packages")
public class TripPackageController {

    private final TripPackageService tripPackageService;

    @Autowired
    public TripPackageController(TripPackageService tripPackageService) {
        this.tripPackageService = tripPackageService;
    }

    @PostMapping
    public ResponseEntity<TripPackage> createTripPackage(@Valid @RequestBody TripPackageDTO tripPackageDTO) {
        TripPackage tripPackage = tripPackageService.createTripPackage(tripPackageDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(tripPackage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripPackage> getTripPackage(@PathVariable Long id) {
        TripPackage tripPackage = tripPackageService.getTripPackageById(id);
        return ResponseEntity.ok(tripPackage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TripPackage> updateTripPackage(@PathVariable Long id, @Valid @RequestBody TripPackageDTO tripPackageDTO) {
        TripPackage tripPackage = tripPackageService.updateTripPackage(id, tripPackageDTO);
        return ResponseEntity.ok(tripPackage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTripPackage(@PathVariable Long id) {
        tripPackageService.deleteTripPackage(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<TripPackageDTO>> getAllTripPackages() {
        List<TripPackageDTO> tripPackages = tripPackageService.getAllTripPackage();
        return ResponseEntity.ok(tripPackages);
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<TripPackage>> getPackagesWithinDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<TripPackage> tripPackages = tripPackageService.getPackagesWithinDateRange(startDate, endDate);
        return ResponseEntity.ok(tripPackages);
    }

    @GetMapping("/price-location")
    public ResponseEntity<List<TripPackage>> getPackagesByPriceRangeAndLocation(
            @RequestParam BigDecimal minPrice,
            @RequestParam BigDecimal maxPrice,
            @RequestParam String location) {
        List<TripPackage> tripPackages = tripPackageService.getPackagesByPriceRangeAndLocation(minPrice, maxPrice, location);
        return ResponseEntity.ok(tripPackages);
    }
}