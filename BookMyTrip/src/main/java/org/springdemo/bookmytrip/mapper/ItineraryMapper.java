package org.springdemo.bookmytrip.mapper;

import org.springdemo.bookmytrip.dto.FlightSegmentDTO;
import org.springdemo.bookmytrip.dto.HotelSegmentDTO;
import org.springdemo.bookmytrip.dto.ItineraryDTO;
import org.springdemo.bookmytrip.dto.TripSegmentDTO;
import org.springdemo.bookmytrip.model.*;

import java.util.stream.Collectors;

public class ItineraryMapper {

    public static ItineraryDTO toDTO(Itinerary itinerary) {
        if (itinerary == null) {
            return null;
        }

        ItineraryDTO dto = new ItineraryDTO();
        dto.setTravelPackageId(itinerary.getTripPackage() != null ? itinerary.getTripPackage().getId() : null);
        dto.setStartDate(itinerary.getStartDate());
        dto.setEndDate(itinerary.getEndDate());

        if (itinerary.getTripSegments() != null) {
            dto.setTripSegments(itinerary.getTripSegments().stream()
                    .map(ItineraryMapper::mapTripSegmentToDTO)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public static Itinerary toEntity(ItineraryDTO dto) {
        if (dto == null) {
            return null;
        }

        Itinerary itinerary = new Itinerary();

        itinerary.setStartDate(dto.getStartDate());
        itinerary.setEndDate(dto.getEndDate());

        if (dto.getTravelPackageId() != null) {
            TripPackage tripPackage = new TripPackage();
            tripPackage.setId(dto.getTravelPackageId());
            itinerary.setTripPackage(tripPackage);
        }

        if (dto.getTripSegments() != null) {
            itinerary.setTripSegments(dto.getTripSegments().stream()
                    .map(segmentDTO -> mapTripSegmentToEntity(segmentDTO, itinerary))
                    .toList());
        }

        return itinerary;
    }

    private static TripSegmentDTO mapTripSegmentToDTO(TripSegment segment) {
        if (segment instanceof FlightSegment flightSegment) {
            return new FlightSegmentMapper().toDTO(flightSegment);
        } else if (segment instanceof HotelSegment hotelSegment) {
            return new HotelSegmentMapper().toDTO(hotelSegment);
        }

        throw new IllegalArgumentException("Unknown segment type: " + segment.getClass());
    }

    private static TripSegment mapTripSegmentToEntity(TripSegmentDTO segmentDTO, Itinerary itinerary) {
        TripSegment segment;
        if (segmentDTO instanceof FlightSegmentDTO flightSegmentDTO) {
            segment = new FlightSegmentMapper().toEntity(flightSegmentDTO);
        } else if (segmentDTO instanceof HotelSegmentDTO hotelSegmentDTO) {
            segment = new HotelSegmentMapper().toEntity(hotelSegmentDTO);
        } else {
            // Add more conditions for other segment types
            throw new IllegalArgumentException("Unknown segment DTO type: " + segmentDTO.getClass());
        }
        segment.setItinerary(itinerary);
        return segment;
    }
}
