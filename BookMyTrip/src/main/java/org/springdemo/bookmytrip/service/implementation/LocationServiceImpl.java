package org.springdemo.bookmytrip.service.implementation;

import org.springdemo.bookmytrip.exception.ResourceNotFoundException;
import org.springdemo.bookmytrip.model.Location;
import org.springdemo.bookmytrip.repository.LocationRepository;
import org.springdemo.bookmytrip.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository repository){
        this.locationRepository = repository;
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location addLocation(Location location) {

        return locationRepository.save(location);
    }

    @Override
    public Location getLocation(Long id) {
        return locationRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("No Location Found with id " + id));
    }
 
    @Override
    public Location updateLocation(Long id, Location requestDTO) {
       Location location = getLocation(id);

       location.setCity(requestDTO.getCity());

       location.setCountry(requestDTO.getCountry());

       location.setAirportCode(requestDTO.getAirportCode());

       locationRepository.save(location);

        return location;
    }

    @Override
    public void removeLocation(Long id) {
        if(locationRepository.existsById(id)){

            locationRepository.deleteById(id);
        }
    }
}
