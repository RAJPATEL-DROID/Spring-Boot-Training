package org.springdemo.bookmytrip.mapper.response;

import org.springdemo.bookmytrip.dto.response.TripPackageResponseDTO;
import org.springdemo.bookmytrip.model.TripPackage;

public class TripPackageResponseMapper {
    private TripPackageResponseMapper(){};

    public static TripPackageResponseDTO toDTO(TripPackage tripPackage) {
        if (tripPackage == null) {
            return null;
        }

        TripPackageResponseDTO dto = new TripPackageResponseDTO();
        dto.setId(tripPackage.getId());
        dto.setTitle(tripPackage.getTitle());
        dto.setDescription(tripPackage.getDescription());
        dto.setPrice(tripPackage.getPrice());

        return dto;
    }

    public static TripPackage toEntity(TripPackageResponseDTO dto) {
        if (dto == null) {
            return null;
        }

        TripPackage tripPackage = new TripPackage();
        tripPackage.setId(dto.getId());
        tripPackage.setTitle(dto.getTitle());
        tripPackage.setDescription(dto.getDescription());
        tripPackage.setPrice(dto.getPrice());

        return tripPackage;
    }
}