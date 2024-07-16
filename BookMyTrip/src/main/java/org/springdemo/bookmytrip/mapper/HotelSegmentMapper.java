package org.springdemo.bookmytrip.mapper;

import org.springdemo.bookmytrip.dto.HotelSegmentDTO;
import org.springdemo.bookmytrip.model.HotelSegment;

public class HotelSegmentMapper extends TripSegmentMapper<HotelSegment, HotelSegmentDTO> {

    @Override
    public HotelSegmentDTO toDTO(HotelSegment entity) {
        if (entity == null) {
            return null;
        }
        HotelSegmentDTO dto = new HotelSegmentDTO();
        mapToDTO(entity, dto);

        // Map HotelSegment specific fields
        dto.setHotelName(entity.getHotelName());
        dto.setAddress(entity.getAddress());
        dto.setCheckInDate(entity.getCheckInDate());
        dto.setCheckOutDate(entity.getCheckOutDate());

        if (entity.getLocation() != null) {
            dto.setLocation(LocationMapper.toDTO(entity.getLocation()));
        }

        return dto;
    }

    @Override
    public HotelSegment toEntity(HotelSegmentDTO dto) {
        if (dto == null) {
            return null;
        }
        HotelSegment entity = new HotelSegment();
        mapToEntity(dto, entity);

        // Map HotelSegment specific fields
        entity.setHotelName(dto.getHotelName());
        entity.setAddress(dto.getAddress());
        entity.setCheckInDate(dto.getCheckInDate());
        entity.setCheckOutDate(dto.getCheckOutDate());

        if (dto.getLocation() != null) {
            entity.setLocation(LocationMapper.toEntity(dto.getLocation()));
        }

        return entity;
    }
}