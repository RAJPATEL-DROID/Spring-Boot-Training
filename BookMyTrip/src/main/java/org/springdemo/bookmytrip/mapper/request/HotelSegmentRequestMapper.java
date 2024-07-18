package org.springdemo.bookmytrip.mapper.request;

import org.springdemo.bookmytrip.dto.request.HotelSegmentRequestDTO;
import org.springdemo.bookmytrip.model.HotelSegment;
import org.springdemo.bookmytrip.model.Itinerary;
import org.springdemo.bookmytrip.model.Location;

public class HotelSegmentRequestMapper {

    public static HotelSegment toEntity(HotelSegmentRequestDTO dto) {

        HotelSegment entity = new HotelSegment();

        entity.setSegmentType(dto.getSegmentType());

        entity.setHotelName(dto.getHotelName());

        entity.setAddress(dto.getAddress());

        entity.setCheckInDate(dto.getCheckInDate());

        entity.setCheckOutDate(dto.getCheckOutDate());

        Itinerary itinerary = new Itinerary();

        itinerary.setId(dto.getItineraryId());

        entity.setItinerary(itinerary);

        Location location = new Location();

        location.setId(dto.getLocationId());

        entity.setLocation(location);

        return entity;
    }
}