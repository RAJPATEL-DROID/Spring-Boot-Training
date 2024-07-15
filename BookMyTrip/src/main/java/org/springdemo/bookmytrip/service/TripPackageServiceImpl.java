package org.springdemo.bookmytrip.service;

import org.springdemo.bookmytrip.dto.TripPackageDTO;
import org.springdemo.bookmytrip.mapper.TripPackageMapper;
import org.springdemo.bookmytrip.model.TripPackage;
import org.springdemo.bookmytrip.repository.TripPackageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripPackageServiceImpl implements TripPackageService{

    @Override
    public List<TripPackageDTO> getAllTripPackage(TripPackageRepository repository) {

        List<TripPackage> tripPackages = repository.findAll().stream().toList();

        return tripPackages.stream().map(TripPackageMapper::mapToTripPackageDTO).toList();

    }
}
