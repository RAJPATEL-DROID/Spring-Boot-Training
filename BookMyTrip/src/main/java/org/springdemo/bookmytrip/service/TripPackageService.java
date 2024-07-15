package org.springdemo.bookmytrip.service;

import org.springdemo.bookmytrip.dto.TripPackageDTO;
import org.springdemo.bookmytrip.model.TripPackage;
import org.springdemo.bookmytrip.repository.TripPackageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TripPackageService {

    List<TripPackageDTO> getAllTripPackage(TripPackageRepository tripPackageRepository);

}
