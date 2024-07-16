package org.springdemo.bookmytrip.service;


import org.springdemo.bookmytrip.dto.ItineraryDTO;
import org.springdemo.bookmytrip.exception.ResourceNotFoundException;
import org.springdemo.bookmytrip.model.Itinerary;
import org.springdemo.bookmytrip.model.TripPackage;
import org.springdemo.bookmytrip.repository.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItineraryServiceImpl implements ItineraryService {

    private final ItineraryRepository itineraryRepository;
    private final TripPackageService tripPackageService;

    @Autowired
    public ItineraryServiceImpl(ItineraryRepository itineraryRepository, TripPackageService tripPackageService) {
        this.itineraryRepository = itineraryRepository;
        this.tripPackageService =  tripPackageService;
    }

    @Override
    public Itinerary createItinerary(ItineraryDTO itineraryDTO) {
        TripPackage travelPackage = tripPackageService.getTripPackageById(itineraryDTO.getTravelPackageId());

        Itinerary itinerary = new Itinerary();
        itinerary.setTripPackage(travelPackage);
        itinerary.setStartDate(itineraryDTO.getStartDate());
        itinerary.setEndDate(itineraryDTO.getEndDate());

        return itineraryRepository.save(itinerary);
    }

    @Override
    public Itinerary getItineraryById(Long id) {
        return itineraryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Itinerary not found with id: " + id));
    }

    @Override
    public Itinerary updateItinerary(Long id, ItineraryDTO itineraryDTO) {
        Itinerary itinerary = getItineraryById(id);
        itinerary.setStartDate(itineraryDTO.getStartDate());
        itinerary.setEndDate(itineraryDTO.getEndDate());
        return itineraryRepository.save(itinerary);
    }

    @Override
    public void deleteItinerary(Long id) {
        Itinerary itinerary = getItineraryById(id);
        itineraryRepository.delete(itinerary);
    }

    @Override
    public List<Itinerary> getAllItineraries() {
        return itineraryRepository.findAll();
    }
}
