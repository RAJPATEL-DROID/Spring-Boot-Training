package org.springdemo.bookmytrip.mapper.request;

import org.springdemo.bookmytrip.dto.request.FlightSegmentRequestDTO;
import org.springdemo.bookmytrip.model.FlightSegment;


public class FlightSegmentRequestMapper {

    public static FlightSegment toEntity(FlightSegmentRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        FlightSegment entity = new FlightSegment();

        entity.setId(dto.getId());

        entity.setSegmentType(dto.getSegmentType());

        entity.setFlightNumber(dto.getFlightNumber());

        entity.setDepartureTime(dto.getDepartureTime());

        entity.setArrivalTime(dto.getArrivalTime());

        entity.setDepartureLocationId(dto.getDepartureLocationId());

        entity.setDepartureLocationId(dto.getArrivalLocationId());

        return entity;
    }
}