package org.springdemo.bookmytrip.mapper.response;

import org.springdemo.bookmytrip.dto.request.LocationRequestDTO;
import org.springdemo.bookmytrip.dto.response.LocationResponseDTO;
import org.springdemo.bookmytrip.model.Location;

public class LocationResponseMapper {

    public static LocationResponseDTO toDTO(Location location) {
        if (location == null) {
            return null;
        }

        return new LocationResponseDTO(
                location.getId(),
                location.getCity(),
                location.getCountry(),
                location.getAirportCode()
        );
    }

    public static Location toEntity(LocationResponseDTO dto) {
        if (dto == null) {
            return null;
        }

        return new Location(
                dto.getId(),
                dto.getCity(),
                dto.getCountry(),
                dto.getAirportCode()
        );
    }
}