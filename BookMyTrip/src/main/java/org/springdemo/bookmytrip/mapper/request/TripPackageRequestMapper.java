package org.springdemo.bookmytrip.mapper.request;

import org.springdemo.bookmytrip.dto.request.TripPackageRequestDTO;
import org.springdemo.bookmytrip.model.TripPackage;

public class TripPackageRequestMapper {

    private TripPackageRequestMapper(){}


    public static TripPackage toEntity(TripPackageRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        TripPackage tripPackage = new TripPackage();
        tripPackage.setTitle(dto.getTitle());
        tripPackage.setDescription(dto.getDescription());
        tripPackage.setPrice(dto.getPrice());

        return tripPackage;
    }
}