package org.springdemo.bookmytrip.mapper.request;

import org.springdemo.bookmytrip.dto.request.HotelSegmentRequestDTO;
import org.springdemo.bookmytrip.model.HotelSegment;

public class HotelSegmentRequestMapper {

    public static HotelSegment toEntity(HotelSegmentRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        HotelSegment entity = new HotelSegment();

        entity.setId(dto.getId());
        entity.setSegmentType(dto.getSegmentType());
        entity.setHotelName(dto.getHotelName());
        entity.setAddress(dto.getAddress());
        entity.setCheckInDate(dto.getCheckInDate());
        entity.setCheckOutDate(dto.getCheckOutDate());

        if(dto.getLocationId() != null) {
            entity.setLocationId(dto.getLocationId());
        }

        return entity;
    }
}