package org.springdemo.bookmytrip.mapper;

import org.springdemo.bookmytrip.dto.TripPackageDTO;
import org.springdemo.bookmytrip.model.TripPackage;

public class TripPackageMapper {

    private TripPackageMapper(){}

    public static TripPackageDTO mapToTripPackageDTO(TripPackage tripPackage){
        return new TripPackageDTO(tripPackage.getId(),tripPackage.getTripName(),tripPackage.getDescription(),tripPackage.getPrice(),tripPackage.getItineraries(),tripPackage.getReviews());
    }

}
