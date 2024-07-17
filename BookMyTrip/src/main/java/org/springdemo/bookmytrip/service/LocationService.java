package org.springdemo.bookmytrip.service;
;
import org.springdemo.bookmytrip.model.Location;

import java.util.List;

public interface LocationService {

    List<Location> getAllLocations();
    Location addLocation(Location location);
    Location getLocation(Long id);
    Location updateLocation(Long id, Location location);
    void removeLocation(Long id);

}
