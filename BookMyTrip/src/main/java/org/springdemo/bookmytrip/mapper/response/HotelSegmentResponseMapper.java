package org.springdemo.bookmytrip.mapper.response;

import org.springdemo.bookmytrip.dto.response.HotelSegmentResponseDTO;
import org.springdemo.bookmytrip.model.HotelSegment;

public class HotelSegmentResponseMapper{

    public static HotelSegmentResponseDTO toDTO(HotelSegment entity) {
        if (entity == null) {
            return null;
        }
        HotelSegmentResponseDTO dto = new HotelSegmentResponseDTO();

        dto.setId(entity.getId());

        dto.setItinerary(ItineraryResponseMapper.toDTO(entity.getItinerary()));

        dto.setSegmentType(entity.getSegmentType());

        dto.setHotelName(entity.getHotelName());

        dto.setAddress(entity.getAddress());

        dto.setCheckInDate(entity.getCheckInDate());

        dto.setCheckOutDate(entity.getCheckOutDate());

        dto.setLocation(entity.getLocation());

        return dto;
    }

    public static HotelSegment toEntity(HotelSegmentResponseDTO dto) {

        if (dto == null) {
            return null;
        }

        HotelSegment entity = new HotelSegment();

        entity.setId(dto.getId());

        entity.setItinerary(ItineraryResponseMapper.toEntity(dto.getItinerary()));

        entity.setSegmentType(dto.getSegmentType());

        entity.setHotelName(dto.getHotelName());

        entity.setAddress(dto.getAddress());

        entity.setCheckInDate(dto.getCheckInDate());

        entity.setCheckOutDate(dto.getCheckOutDate());

        entity.setLocation(dto.getLocation());

        return entity;
    }
}