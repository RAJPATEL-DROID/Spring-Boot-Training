package org.springdemo.bookmytrip.mapper;

import org.springdemo.bookmytrip.dto.TripPackageDTO;
import org.springdemo.bookmytrip.model.TripPackage;
import org.springdemo.bookmytrip.model.Itinerary;
import org.springdemo.bookmytrip.model.Review;

import java.util.stream.Collectors;

public class TripPackageMapper {

    public static TripPackageDTO toDTO(TripPackage tripPackage) {
        if (tripPackage == null) {
            return null;
        }

        TripPackageDTO dto = new TripPackageDTO();
        dto.setTitle(tripPackage.getTitle());
        dto.setDescription(tripPackage.getDescription());
        dto.setPrice(tripPackage.getPrice());

        if (tripPackage.getItineraries() != null) {
            dto.setItineraries(tripPackage.getItineraries().stream()
                    .map(ItineraryMapper::toDTO)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public static TripPackage toEntity(TripPackageDTO dto) {
        if (dto == null) {
            return null;
        }

        TripPackage tripPackage = new TripPackage();
        tripPackage.setTitle(dto.getTitle());
        tripPackage.setDescription(dto.getDescription());
        tripPackage.setPrice(dto.getPrice());

        if (dto.getItineraries() != null) {
            tripPackage.setItineraries(dto.getItineraries().stream()
                    .map(ItineraryMapper::toEntity).toList());
        }

        return tripPackage;
    }
}