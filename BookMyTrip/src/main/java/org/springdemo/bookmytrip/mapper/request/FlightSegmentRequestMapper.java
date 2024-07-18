package org.springdemo.bookmytrip.mapper.request;

import org.springdemo.bookmytrip.dto.request.FlightSegmentRequestDTO;
import org.springdemo.bookmytrip.model.FlightSegment;
import org.springdemo.bookmytrip.model.Itinerary;
import org.springdemo.bookmytrip.model.Location;


public class FlightSegmentRequestMapper {

    public static FlightSegment toEntity(FlightSegmentRequestDTO dto) {

        FlightSegment entity = new FlightSegment();

        entity.setSegmentType(dto.getSegmentType());

        entity.setFlightNumber(dto.getFlightNumber());

        entity.setDepartureTime(dto.getDepartureTime());

        entity.setArrivalTime(dto.getArrivalTime());

        Itinerary itinerary = new Itinerary();

        itinerary.setId(dto.getItineraryId());

        entity.setItinerary(itinerary);

        Location arrivallocation = new Location();

        arrivallocation.setId(dto.getArrivalLocationId());

        entity.setArrivalLocation(arrivallocation);

        Location departureLocation = new Location();

        departureLocation.setId(dto.getDepartureLocationId());

        entity.setDepartureLocation(departureLocation);

        return entity;
    }
}