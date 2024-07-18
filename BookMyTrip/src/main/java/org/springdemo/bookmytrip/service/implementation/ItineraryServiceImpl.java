package org.springdemo.bookmytrip.service.implementation;

import org.springdemo.bookmytrip.exception.ResourceNotFoundException;
import org.springdemo.bookmytrip.model.Itinerary;
import org.springdemo.bookmytrip.model.TripPackage;
import org.springdemo.bookmytrip.repository.ItineraryRepository;
import org.springdemo.bookmytrip.service.ItineraryService;
import org.springdemo.bookmytrip.service.TripPackageService;
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
    public Itinerary createItinerary(Itinerary itinerary) {
        TripPackage tripPackage = tripPackageService.getTripPackageById(itinerary.getTripPackage().getId());

        Itinerary itineraryObj = new Itinerary();
        itineraryObj.setTripPackage(tripPackage);
        itineraryObj.setStartDate(itinerary.getStartDate());
        itineraryObj.setEndDate(itinerary.getEndDate());

        return itineraryRepository.save(itineraryObj);
    }

    @Override
    public Itinerary getItineraryById(Long itineraryId) {

        return itineraryRepository.findById(itineraryId)
                .orElseThrow(() -> new ResourceNotFoundException("Itinerary not found with id: " + itineraryId));
    }

    @Override
    public Itinerary updateItinerary(Long id, Itinerary itinerary) {

        Itinerary itineraryObj = getItineraryById(id);

        TripPackage tripPackage = tripPackageService.getTripPackageById(itinerary.getTripPackage().getId());

        itineraryObj.setTripPackage(tripPackage);

        itineraryObj.setStartDate(itinerary.getStartDate());

        itineraryObj.setEndDate(itinerary.getEndDate());

        return itineraryRepository.save(itineraryObj);
    }

    @Override
    public void deleteItinerary(Long id) {

        itineraryRepository.deleteById(id);

    }

    @Override
    public List<Itinerary> getAllItineraries() {
        return itineraryRepository.findAll();
    }
}
