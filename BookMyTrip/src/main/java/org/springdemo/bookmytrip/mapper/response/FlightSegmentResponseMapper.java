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

        dto.setSegmentType(entity.getSegmentType());

        dto.setFlightNumber(entity.getFlightNumber());

        dto.setDepartureTime(entity.getDepartureTime());

        dto.setArrivalTime(entity.getArrivalTime());

        dto.setDepartureLocationId(entity.getDepartureLocationId());

        dto.setArrivalLocationId(entity.getArrivalLocationId());

        return dto;
    }

    public static FlightSegment toEntity(FlightSegmentResponseDTO dto) {
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

        entity.setArrivalLocationId(dto.getArrivalLocationId());

        return entity;
    }
}