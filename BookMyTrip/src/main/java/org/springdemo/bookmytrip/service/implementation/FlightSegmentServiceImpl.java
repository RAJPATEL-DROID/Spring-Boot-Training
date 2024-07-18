package org.springdemo.bookmytrip.service.implementation;

import org.springdemo.bookmytrip.exception.ResourceNotFoundException;
import org.springdemo.bookmytrip.model.FlightSegment;
import org.springdemo.bookmytrip.model.Itinerary;
import org.springdemo.bookmytrip.model.Location;
import org.springdemo.bookmytrip.repository.FlightRepository;
import org.springdemo.bookmytrip.service.FlightSegmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightSegmentServiceImpl implements FlightSegmentService {

    private final LocationServiceImpl locationServiceImpl;
    private final FlightRepository flightRepository;
    private final ItineraryServiceImpl itineraryServiceImpl;

    public FlightSegmentServiceImpl(FlightRepository repository, LocationServiceImpl locationServiceImpl, ItineraryServiceImpl itineraryServiceImpl){
        this.flightRepository = repository;
        this.locationServiceImpl = locationServiceImpl;
        this.itineraryServiceImpl = itineraryServiceImpl;
    }

    @Override
    public FlightSegment getFlightSegment(Long id) {
        return flightRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Flight found with id: " + id));
    }

    @Override
    public List<FlightSegment> getAllFlightSegment() {


        return flightRepository.findAll();
    }

    @Override
    public FlightSegment addFlightSegment(FlightSegment flightSegment) {

        Long itineraryId = flightSegment.getItinerary().getId();

        Itinerary itinerary = itineraryServiceImpl.getItineraryById(itineraryId);

        flightSegment.setItinerary(itinerary);

        Long arrivalLocationId = flightSegment.getArrivalLocation().getId();

        Location arrivalLocation = locationServiceImpl.getLocation(arrivalLocationId);

        flightSegment.setArrivalLocation(arrivalLocation);

        Long departureLocationId = flightSegment.getDepartureLocation().getId();

        Location departureLocation = locationServiceImpl.getLocation(departureLocationId);

        flightSegment.setDepartureLocation(departureLocation);

        return flightRepository.save(flightSegment);
    }

    @Override
    public FlightSegment updateFlightSegment(Long id,FlightSegment updatedFlight) {

        FlightSegment flightSegment = getFlightSegment(id);

        flightSegment.setFlightNumber(updatedFlight.getFlightNumber());

        flightSegment.setArrivalTime(updatedFlight.getArrivalTime());

        flightSegment.setDepartureTime(updatedFlight.getDepartureTime());

        Long itineraryId = flightSegment.getItinerary().getId();

        Itinerary itinerary = itineraryServiceImpl.getItineraryById(itineraryId);

        flightSegment.setItinerary(itinerary);

        Long arrivalLocationId = flightSegment.getArrivalLocation().getId();

        Location arrivalLocation = locationServiceImpl.getLocation(arrivalLocationId);

        flightSegment.setArrivalLocation(arrivalLocation);

        Long departureLocationId = flightSegment.getDepartureLocation().getId();

        Location departureLocation = locationServiceImpl.getLocation(departureLocationId);

        flightSegment.setDepartureLocation(departureLocation);

        flightRepository.save(flightSegment);

        return flightSegment;
    }

    @Override
    public void deleteFlightSegment(Long id) {
         if(flightRepository.existsById(id)){
             flightRepository.deleteById(id);
         }
    }
}
