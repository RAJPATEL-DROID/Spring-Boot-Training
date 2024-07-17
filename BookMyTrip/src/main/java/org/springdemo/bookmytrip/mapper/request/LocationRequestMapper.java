package org.springdemo.bookmytrip.mapper.request;

import org.springdemo.bookmytrip.dto.request.LocationRequestDTO;
import org.springdemo.bookmytrip.model.Location;

public class LocationRequestMapper {

    public static Location toEntity(LocationRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        return new Location(
                dto.getCity(),
                dto.getCountry(),
                dto.getAirportCode()
        );
    }
}