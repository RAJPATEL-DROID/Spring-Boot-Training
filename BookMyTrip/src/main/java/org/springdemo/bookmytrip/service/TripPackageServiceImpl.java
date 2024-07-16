package org.springdemo.bookmytrip.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springdemo.bookmytrip.dto.*;
import org.springdemo.bookmytrip.exception.ResourceNotFoundException;
import org.springdemo.bookmytrip.mapper.TripPackageMapper;
import org.springdemo.bookmytrip.model.*;
import org.springdemo.bookmytrip.repository.ItineraryRepository;
import org.springdemo.bookmytrip.repository.LocationRepository;
import org.springdemo.bookmytrip.repository.TripPackageRepository;
import org.springdemo.bookmytrip.repository.TripSegmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class TripPackageServiceImpl implements TripPackageService{

    private final TripPackageRepository tripPackageRepository;
    private final ItineraryRepository itineraryRepository;
    private final TripSegmentRepository tripSegmentRepository;
    private final LocationRepository locationRepository;
    private final EntityManager entityManager;

    @Autowired
    public TripPackageServiceImpl(TripPackageRepository tripPackageRepository, EntityManager entityManager,
                                  ItineraryRepository itineraryRepository,
                                  TripSegmentRepository tripSegmentRepository,
                                  LocationRepository locationRepository) {
        this.tripPackageRepository = tripPackageRepository;
        this.entityManager = entityManager;
        this.tripSegmentRepository = tripSegmentRepository;
        this.locationRepository = locationRepository;
        this.itineraryRepository = itineraryRepository;
    }

    @Override
    public TripPackage createTripPackage(TripPackageDTO tripPackageDTO) {
        TripPackage travelPackage = new TripPackage();
        travelPackage.setTitle(tripPackageDTO.getTitle());
        travelPackage.setDescription(tripPackageDTO.getDescription());
        travelPackage.setPrice(tripPackageDTO.getPrice());

        travelPackage = tripPackageRepository.save(travelPackage);

        for (ItineraryDTO itineraryDTO : tripPackageDTO.getItineraries()) {
            Itinerary itinerary = new Itinerary();
            itinerary.setStartDate(itineraryDTO.getStartDate());
            itinerary.setEndDate(itineraryDTO.getEndDate());
            itinerary.setTripPackage(travelPackage);

            itinerary = itineraryRepository.save(itinerary);

            for (TripSegmentDTO segmentDTO : itineraryDTO.getTripSegments()) {
                TripSegment segment;
                if (segmentDTO instanceof FlightSegmentDTO flightSegmentDTO) {
                    FlightSegmentDTO flightDTO = flightSegmentDTO;
                    FlightSegment flightSegment = new FlightSegment();
                    flightSegment.setFlightNumber(flightDTO.getFlightNumber());
                    flightSegment.setDepartureTime(flightDTO.getDepartureTime());
                    flightSegment.setArrivalTime(flightDTO.getArrivalTime());
                    flightSegment.setDepartureLocation(createOrGetLocation(flightDTO.getDepartureLocation()));
                    flightSegment.setArrivalLocation(createOrGetLocation(flightDTO.getArrivalLocation()));
                    segment = flightSegment;
                } else {
                    HotelSegmentDTO hotelDTO = (HotelSegmentDTO) segmentDTO;
                    HotelSegment hotelSegment = new HotelSegment();
                    hotelSegment.setHotelName(hotelDTO.getHotelName());
                    hotelSegment.setAddress(hotelDTO.getAddress());
                    hotelSegment.setCheckInDate(hotelDTO.getCheckInDate());
                    hotelSegment.setCheckOutDate(hotelDTO.getCheckOutDate());
                    hotelSegment.setLocation(createOrGetLocation(hotelDTO.getLocation()));
                    segment = hotelSegment;
                }
                segment.setItinerary(itinerary);
                tripSegmentRepository.save(segment);
            }
        }
        return travelPackage;
    }

    private Location createOrGetLocation(LocationDTO locationDTO) {

        Location location = locationRepository.findByAirportCode(locationDTO.getAirportCode());

        if (location == null) {
            location = new Location(
                    locationDTO.getCity(),
                    locationDTO.getCountry(),
                    locationDTO.getAirportCode()
            );
            location = locationRepository.save(location);
        }
        return location;
    }


    @Override
    public TripPackage getTripPackageById(Long id) {
        return tripPackageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Travel package not found with id: " + id));
    }

    @Override
    public TripPackage updateTripPackage(Long id, TripPackageDTO travelPackageDTO) {
        TripPackage travelPackage = getTripPackageById(id);
        travelPackage.setTitle(travelPackageDTO.getTitle());
        travelPackage.setDescription(travelPackageDTO.getDescription());
        travelPackage.setPrice(travelPackageDTO.getPrice());
        return tripPackageRepository.save(travelPackage);
    }

    @Override
    public void deleteTripPackage(Long id) {
        TripPackage travelPackage = getTripPackageById(id);
        tripPackageRepository.delete(travelPackage);
    }

    @Override
    public List<TripPackage> getTripPackagesByMaxPrice(BigDecimal maxPrice) {
        return tripPackageRepository.findByPriceLessThanEqual(maxPrice);
    }

    @Override
    public List<TripPackageDTO> getAllTripPackage() {

        List<TripPackage> tripPackages = tripPackageRepository.findAll().stream().toList();

        return tripPackages.stream().map(TripPackageMapper::toDTO).toList();

    }
    @Override
    public List<TripPackage> getPackagesWithinDateRange(LocalDate startDate, LocalDate endDate) {
        return tripPackageRepository.findPackagesWithinDateRange(startDate, endDate);
    }

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
