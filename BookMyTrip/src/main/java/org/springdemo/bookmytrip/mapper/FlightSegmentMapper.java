package org.springdemo.bookmytrip.mapper;

import org.springdemo.bookmytrip.dto.FlightSegmentDTO;
import org.springdemo.bookmytrip.model.FlightSegment;


public class FlightSegmentMapper extends TripSegmentMapper<FlightSegment, FlightSegmentDTO> {

    @Override
    public FlightSegmentDTO toDTO(FlightSegment entity) {
        if (entity == null) {
            return null;
        }
        FlightSegmentDTO dto = new FlightSegmentDTO();
        mapToDTO(entity, dto);

        dto.setFlightNumber(entity.getFlightNumber());
        dto.setDepartureTime(entity.getDepartureTime());
        dto.setArrivalTime(entity.getArrivalTime());

        if (entity.getDepartureLocation() != null) {
            dto.setDepartureLocation(LocationMapper.toDTO(entity.getDepartureLocation()));
        }
        if (entity.getArrivalLocation() != null) {
            dto.setArrivalLocation(LocationMapper.toDTO(entity.getArrivalLocation()));
        }

        return dto;
    }

    @Override
    public FlightSegment toEntity(FlightSegmentDTO dto) {
        if (dto == null) {
            return null;
        }
        FlightSegment entity = new FlightSegment();
        mapToEntity(dto, entity);

        // Map FlightSegment specific fields
        entity.setFlightNumber(dto.getFlightNumber());
        entity.setDepartureTime(dto.getDepartureTime());
        entity.setArrivalTime(dto.getArrivalTime());

        if (dto.getDepartureLocation() != null) {
            entity.setDepartureLocation(LocationMapper.toEntity(dto.getDepartureLocation()));
        }
        if (dto.getArrivalLocation() != null) {
            entity.setArrivalLocation(LocationMapper.toEntity(dto.getArrivalLocation()));
        }

        return entity;
    }
}