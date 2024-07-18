package org.springdemo.bookmytrip.mapper.response;

import org.springdemo.bookmytrip.dto.response.FlightSegmentResponseDTO;
import org.springdemo.bookmytrip.model.FlightSegment;


public class FlightSegmentResponseMapper {

    public static FlightSegmentResponseDTO toDTO(FlightSegment entity) {

        if (entity == null) {
            return null;
        }

        FlightSegmentResponseDTO dto = new FlightSegmentResponseDTO();

        dto.setId(entity.getId());

        dto.setItinerary(ItineraryResponseMapper.toDTO(entity.getItinerary()));

        dto.setSegmentType(entity.getSegmentType());

        dto.setFlightNumber(entity.getFlightNumber());

        dto.setDepartureTime(entity.getDepartureTime());

        dto.setArrivalTime(entity.getArrivalTime());

        dto.setDepartureLocation(entity.getDepartureLocation());

        dto.setArrivalLocation(entity.getArrivalLocation());

        return dto;
    }

    public static FlightSegment toEntity(FlightSegmentResponseDTO dto) {
        if (dto == null) {
            return null;
        }
        FlightSegment entity = new FlightSegment();

        entity.setId(dto.getId());

        entity.setItinerary(ItineraryResponseMapper.toEntity(dto.getItinerary()));

        entity.setSegmentType(dto.getSegmentType());

        entity.setFlightNumber(dto.getFlightNumber());

        entity.setDepartureTime(dto.getDepartureTime());

        entity.setArrivalTime(dto.getArrivalTime());

        entity.setDepartureLocation(dto.getDepartureLocation());

        entity.setArrivalLocation(dto.getArrivalLocation());

        return entity;
    }
}