package org.springdemo.bookmytrip.service.implementation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springdemo.bookmytrip.exception.ResourceNotFoundException;
import org.springdemo.bookmytrip.model.TripPackage;
import org.springdemo.bookmytrip.repository.ItineraryRepository;
import org.springdemo.bookmytrip.repository.LocationRepository;
import org.springdemo.bookmytrip.repository.TripPackageRepository;
import org.springdemo.bookmytrip.repository.TripSegmentRepository;
import org.springdemo.bookmytrip.service.TripPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class TripPackageServiceImpl implements TripPackageService {

    private final TripPackageRepository tripPackageRepository;
    private final EntityManager entityManager;

    @Autowired
    public TripPackageServiceImpl(TripPackageRepository tripPackageRepository, EntityManager entityManager)
    {
        this.tripPackageRepository = tripPackageRepository;
        this.entityManager = entityManager;
    }

    @Override
    public TripPackage createTripPackage(TripPackage tripPackage) {
        return tripPackageRepository.save(tripPackage);
    }


    @Override
    public TripPackage getTripPackageById(Long id) {
        return tripPackageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trip Package not found with id: " + id));
    }

    @Override
    public TripPackage updateTripPackage(Long id, TripPackage tripPackage) {
        TripPackage travelPackage = getTripPackageById(id);

        travelPackage.setTitle(tripPackage.getTitle());
        travelPackage.setDescription(tripPackage.getDescription());
        travelPackage.setPrice(tripPackage.getPrice());

        return tripPackageRepository.save(travelPackage);
    }

    @Override
    public void deleteTripPackage(Long id) {
        if(tripPackageRepository.existsById(id)){
            tripPackageRepository.deleteById(id);
        }
    }

    @Override
    public List<TripPackage> getTripPackagesByMaxPrice(BigDecimal maxPrice) {
        return tripPackageRepository.findByPriceLessThanEqual(maxPrice);
    }

    @Override
    public List<TripPackage> getAllTripPackage() {
        return tripPackageRepository.findAll();
    }
//
//    @Override
//    public List<TripPackage> getPackagesWithinDateRange(LocalDate startDate, LocalDate endDate) {
//        return tripPackageRepository.findPackagesWithinDateRange(startDate, endDate);
//    }

    @Override
    public List<TripPackage> getPackagesByPriceRangeAndLocation(BigDecimal minPrice, BigDecimal maxPrice, String location) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TripPackage> query = cb.createQuery(TripPackage.class);
        Root<TripPackage> root = query.from(TripPackage.class);

        Join<Object, Object> itineraries = root.join("itineraries");
        Join<Object, Object> segments = itineraries.join("travelSegments");
        Join<Object, Object> locations = segments.join("location");

        Predicate pricePredicate = cb.between(root.get("price"), minPrice, maxPrice);
        Predicate locationPredicate = cb.like(locations.get("city"), "%" + location + "%");

        query.select(root).where(cb.and(pricePredicate, locationPredicate)).distinct(true);

        return entityManager.createQuery(query).getResultList();
    }

}
