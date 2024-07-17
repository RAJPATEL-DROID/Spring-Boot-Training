package org.springdemo.bookmytrip.service;

import org.springdemo.bookmytrip.exception.ResourceNotFoundException;
import org.springdemo.bookmytrip.model.FlightSegment;
import org.springdemo.bookmytrip.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightSegmentServiceImpl implements FlightSegmentService{

    FlightRepository flightRepository;

    public FlightSegmentServiceImpl(FlightRepository repository){
        this.flightRepository = repository;
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
        return flightRepository.save(flightSegment);
    }

    @Override
    public FlightSegment updateFlightSegment(Long id, FlightSegment updatedflight) {

        FlightSegment flightSegment = getFlightSegment(id);

        flightSegment.setFlightNumber(updatedflight.getFlightNumber());
        flightSegment.setArrivalTime(updatedflight.getArrivalTime());
        flightSegment.setDepartureTime(updatedflight.getDepartureTime());
        flightSegment.setArrivalLocationId(updatedflight.getArrivalLocationId());
        flightSegment.setDepartureLocationId(updatedflight.getDepartureLocationId());

        flightRepository.save(flightSegment);

        return flightSegment;
    }

    @Override
    public void deleteFlightSegment(Long id) {
         flightRepository.deleteById(id);
    }
}
