package org.springdemo.bookmytrip.mapper.response;

import org.springdemo.bookmytrip.dto.response.ItineraryResponseDTO;
import org.springdemo.bookmytrip.model.*;

public class ItineraryResponseMapper {

    public static ItineraryResponseDTO toDTO(Itinerary itinerary) {
        if (itinerary == null) {
            return null;
        }

        ItineraryResponseDTO dto = new ItineraryResponseDTO();
        dto.setId(itinerary.getId());
        dto.setTripPackage(TripPackageResponseMapper.toDTO(itinerary.getTripPackage()));
        dto.setStartDate(itinerary.getStartDate());
        dto.setEndDate(itinerary.getEndDate());

        return dto;
    }

    public static Itinerary toEntity(ItineraryResponseDTO dto) {
        if (dto == null) {
            return null;
        }

        Itinerary itinerary = new Itinerary();
        itinerary.setId(dto.getId());
        itinerary.setStartDate(dto.getStartDate());
        itinerary.setEndDate(dto.getEndDate());
        itinerary.setTripPackage(TripPackageResponseMapper.toEntity(dto.getTripPackage()));

        return itinerary;
    }
}
