package org.springdemo.bookmytrip.controller;

import jakarta.validation.Valid;
import org.springdemo.bookmytrip.dto.request.TripPackageRequestDTO;
import org.springdemo.bookmytrip.dto.response.TripPackageResponseDTO;
import org.springdemo.bookmytrip.mapper.request.TripPackageRequestMapper;
import org.springdemo.bookmytrip.mapper.response.TripPackageResponseMapper;
import org.springdemo.bookmytrip.model.TripPackage;
import org.springdemo.bookmytrip.service.TripPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/travel-package")
public class TripPackageController {

    private final TripPackageService tripPackageService;

    @Autowired
    public TripPackageController(TripPackageService tripPackageService) {
        this.tripPackageService = tripPackageService;
    }

    @PostMapping
    public ResponseEntity<TripPackageResponseDTO> createTripPackage(@Valid @RequestBody TripPackageRequestDTO tripPackageRequestDTO) {
        TripPackage tripPackage = TripPackageRequestMapper.toEntity(tripPackageRequestDTO);

        TripPackage responseTripPackage = tripPackageService.createTripPackage(tripPackage);

        TripPackageResponseDTO tripPackageDTOS = TripPackageResponseMapper.toDTO(responseTripPackage);

        return ResponseEntity.status(HttpStatus.CREATED).body(tripPackageDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripPackageResponseDTO> getTripPackage(@PathVariable Long id) {
        TripPackage responseTripPackage= tripPackageService.getTripPackageById(id);

        TripPackageResponseDTO tripPackage = TripPackageResponseMapper.toDTO(responseTripPackage);

        return ResponseEntity.ok(tripPackage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TripPackageResponseDTO> updateTripPackage(@PathVariable Long id, @Valid @RequestBody TripPackageRequestDTO tripPackageRequestDTO) {

        TripPackage tripPackage = TripPackageRequestMapper.toEntity(tripPackageRequestDTO);

        TripPackage responseTripPackage = tripPackageService.updateTripPackage(id, tripPackage);

        TripPackageResponseDTO tripPackageDTOS = TripPackageResponseMapper.toDTO(responseTripPackage);

        return ResponseEntity.ok(tripPackageDTOS);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTripPackage(@PathVariable Long id) {
        tripPackageService.deleteTripPackage(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<TripPackageResponseDTO>> getAllTripPackages() {
        List<TripPackage> tripPackages = tripPackageService.getAllTripPackage();

        List<TripPackageResponseDTO> tripPackageResponseDTOS = tripPackages.stream().map(TripPackageResponseMapper::toDTO).toList();

        return ResponseEntity.ok(tripPackageResponseDTOS);
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<TripPackageResponseDTO>> getPackagesWithinDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        List<TripPackage> tripPackages = tripPackageService.getPackagesWithinDateRange(startDate, endDate);

        List<TripPackageResponseDTO> tripPackageResponseDTOS = tripPackages.stream().map(TripPackageResponseMapper::toDTO).toList();

        return ResponseEntity.ok(tripPackageResponseDTOS);
    }

    @GetMapping("/price-location")
    public ResponseEntity<List<TripPackageResponseDTO>> getPackagesByPriceRangeAndLocation(
            @RequestParam BigDecimal minPrice,
            @RequestParam BigDecimal maxPrice,
            @RequestParam String location) {

        List<TripPackage> tripPackages = tripPackageService.getPackagesByPriceRangeAndLocation(minPrice, maxPrice, location);


        List<TripPackageResponseDTO> tripPackageResponseDTOS = tripPackages.stream().map(TripPackageResponseMapper::toDTO).toList();

        return ResponseEntity.ok(tripPackageResponseDTOS);

    }
}