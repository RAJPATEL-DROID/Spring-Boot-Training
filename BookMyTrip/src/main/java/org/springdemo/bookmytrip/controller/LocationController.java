package org.springdemo.bookmytrip.controller;

import org.springdemo.bookmytrip.dto.request.LocationRequestDTO;
import org.springdemo.bookmytrip.dto.response.LocationResponseDTO;
import org.springdemo.bookmytrip.mapper.request.LocationRequestMapper;
import org.springdemo.bookmytrip.mapper.response.LocationResponseMapper;
import org.springdemo.bookmytrip.model.Location;
import org.springdemo.bookmytrip.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    LocationService locationService;

    public LocationController(LocationService locationService)
    {
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<List<LocationResponseDTO>> getAllLocations(){
        List<Location> locations = locationService.getAllLocations();

        List<LocationResponseDTO> locationResponseDTOS= locations.stream().map(LocationResponseMapper::toDTO).toList();

        return ResponseEntity.ok(locationResponseDTOS);
    }

    @PostMapping
    public ResponseEntity<LocationResponseDTO> addLocation(@RequestBody LocationRequestDTO requestLocation){
        Location location = LocationRequestMapper.toEntity(requestLocation);

        Location locationResponse =  locationService.addLocation(location);

        LocationResponseDTO locationResponseDTOS= LocationResponseMapper.toDTO(locationResponse);

        return ResponseEntity.ok(locationResponseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationResponseDTO> getLocation(@PathVariable Long id){

        LocationResponseDTO location = LocationResponseMapper.toDTO(locationService.getLocation(id));

        return ResponseEntity.ok(location);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocationResponseDTO> updateLocation(@PathVariable Long id, @RequestBody LocationRequestDTO requestLocation){
        Location location = LocationRequestMapper.toEntity(requestLocation);

        Location responseLocation = locationService.updateLocation(id,location);

        LocationResponseDTO locationResponseDTO = LocationResponseMapper.toDTO(responseLocation);

        return ResponseEntity.ok(locationResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id){
        locationService.removeLocation(id);

        return ResponseEntity.noContent().build();
    }


}
