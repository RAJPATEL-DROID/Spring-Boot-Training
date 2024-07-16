package org.springdemo.bookmytrip.mapper;

import org.springdemo.bookmytrip.dto.TripSegmentDTO;
import org.springdemo.bookmytrip.model.TripSegment;

public abstract class TripSegmentMapper<E extends TripSegment, D extends TripSegmentDTO> {

    protected void mapToDTO(E entity, D dto) {
        if (entity == null || dto == null) {
            return;
        }

        dto.setSegmentType(entity.getSegmentType());
    }

    protected void mapToEntity(D dto, E entity) {
        if (dto == null || entity == null) {
            return;
        }

        entity.setSegmentType(dto.getSegmentType());
    }

    public abstract D toDTO(E entity);

    public abstract E toEntity(D dto);
}