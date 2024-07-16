package org.springdemo.bookmytrip.service;

import org.springdemo.bookmytrip.dto.ItineraryDTO;
import org.springdemo.bookmytrip.model.Itinerary;

import java.util.List;

public interface ItineraryService {
    Itinerary createItinerary(ItineraryDTO itineraryDTO);
    Itinerary getItineraryById(Long id);
    Itinerary updateItinerary(Long id, ItineraryDTO itineraryDTO);
    void deleteItinerary(Long id);
    List<Itinerary> getAllItineraries();
}
