package org.springdemo.bookmytrip.service;

import org.springdemo.bookmytrip.model.Itinerary;

import java.util.List;

public interface ItineraryService {
    Itinerary createItinerary(Itinerary itinerary);
    Itinerary getItineraryById(Long itineraryId);
    Itinerary updateItinerary(Long id, Itinerary itinerary);
    void deleteItinerary(Long id);
    List<Itinerary> getAllItineraries();
}
