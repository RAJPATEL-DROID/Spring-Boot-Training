package org.springdemo.bookmytrip.service.implementation;

import org.springdemo.bookmytrip.exception.ResourceNotFoundException;
import org.springdemo.bookmytrip.model.HotelSegment;
import org.springdemo.bookmytrip.model.Itinerary;
import org.springdemo.bookmytrip.model.Location;
import org.springdemo.bookmytrip.repository.HotelRepository;
import org.springdemo.bookmytrip.service.ItineraryService;
import org.springdemo.bookmytrip.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelSegmentServiceImpl implements org.springdemo.bookmytrip.service.HotelSegmentService {

    private final HotelRepository hotelRepository;
    private final LocationService locationService;
    private ItineraryService itineraryService;

    public HotelSegmentServiceImpl(HotelRepository hotelRepository,LocationService locationService,ItineraryService itineraryServiceImpl){
        this.hotelRepository = hotelRepository;
        this.locationService =locationService;
        this.itineraryService = itineraryServiceImpl;
    }


    @Override
    public HotelSegment getHotelSegment(Long id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Hotel Exist with id :" + id));
    }

    @Override
    public List<HotelSegment> getAllHotelSegments() {
        return hotelRepository.findAll();
    }

    @Override
    public HotelSegment addHotelSegment(HotelSegment hotelSegment) {

        Long itineraryId = hotelSegment.getItinerary().getId();

        Itinerary itinerary = itineraryService.getItineraryById(itineraryId);

        hotelSegment.setItinerary(itinerary);

        Location location = locationService.getLocation(hotelSegment.getLocation().getId());

        hotelSegment.setLocation(location);

        return hotelRepository.save(hotelSegment);

    }

    @Override
    public HotelSegment updateHotelSegment(Long id, HotelSegment newHotelSegment) {
        HotelSegment hotelSegment= getHotelSegment(id);

        hotelSegment.setHotelName(newHotelSegment.getHotelName());

        Long itineraryId = hotelSegment.getItinerary().getId();

        Itinerary itinerary = itineraryService.getItineraryById(itineraryId);

        hotelSegment.setItinerary(itinerary);

        Location location = locationService.getLocation(hotelSegment.getLocation().getId());

        hotelSegment.setLocation(location);

        hotelSegment.setAddress(newHotelSegment.getAddress());

        hotelSegment.setCheckInDate(newHotelSegment.getCheckInDate());

        hotelSegment.setCheckOutDate(newHotelSegment.getCheckOutDate());

        return hotelRepository.save(hotelSegment);

    }

    @Override
    public void deleteHotelSegment(Long id) {
        if(hotelRepository.existsById(id)){
            hotelRepository.deleteById(id);
        }
    }

}
