package org.springdemo.bookmytrip.mapper;

import org.springdemo.bookmytrip.dto.LocationDTO;
import org.springdemo.bookmytrip.model.Location;

public class LocationMapper {

    public static LocationDTO toDTO(Location location) {
        if (location == null) {
            return null;
        }

        return new LocationDTO(
                location.getCity(),
                location.getCountry(),
                location.getAirportCode()
        );
    }

    public static Location toEntity(LocationDTO dto) {
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