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

        TripPackage tripPackage = new TripPackage();

        tripPackage.setId(dto.getTravelPackageId());

        itinerary.setTripPackage(tripPackage);

        return itinerary;
    }
}
