package org.springdemo.bookmytrip.mapper.request;

import org.springdemo.bookmytrip.dto.request.ItineraryRequestDTO;

import org.springdemo.bookmytrip.model.*;

public class ItineraryRequestMapper {

    public static Itinerary toEntity(ItineraryRequestDTO dto) {
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

//        if (dto.getTripSegments() != null) {
//            itinerary.setTripSegments(dto.getTripSegments().stream()
//                    .map(segmentDTO -> mapTripSegmentToEntity(segmentDTO, itinerary))
//                    .toList());
//        }

        return itinerary;
    }

//    private static TripSegmentResponseDTO mapTripSegmentToDTO(TripSegment segment) {
//        if (segment instanceof FlightSegment flightSegment) {
//            return new FlightSegmentRequestRequestMapper().toDTO(flightSegment);
//        } else if (segment instanceof HotelSegment hotelSegment) {
//            return new HotelSegmentRequestRequestMapper().toDTO(hotelSegment);
//        }
//
//        throw new IllegalArgumentException("Unknown segment type: " + segment.getClass());
//    }

//    private static TripSegment mapTripSegmentToEntity(TripSegmentRequestDTO segmentDTO, Itinerary itinerary) {
//        TripSegment segment;
//        if (segmentDTO instanceof FlightSegmentRequestDTO flightSegmentRequestDTO) {
//            segment = new FlightSegmentRequestRequestMapper().toEntity(flightSegmentRequestDTO);
//        } else if (segmentDTO instanceof HotelSegmentRequestDTO hotelSegmentRequestDTO) {
//            segment = new HotelSegmentRequestRequestMapper().toEntity(hotelSegmentRequestDTO);
//        } else {
//            // Add more conditions for other segment types
//            throw new IllegalArgumentException("Unknown segment DTO type: " + segmentDTO.getClass());
//        }
//        segment.setItinerary(itinerary);
//        return segment;
//    }
}
