package org.springdemo.bookmytrip.service;

import org.springdemo.bookmytrip.model.FlightSegment;

import java.util.List;

public interface FlightSegmentService {

    FlightSegment getFlightSegment(Long id);

    List<FlightSegment> getAllFlightSegment();

    FlightSegment addFlightSegment(FlightSegment flightSegment);

    FlightSegment updateFlightSegment(Long id, FlightSegment flightSegment);

    void deleteFlightSegment(Long id);
}
