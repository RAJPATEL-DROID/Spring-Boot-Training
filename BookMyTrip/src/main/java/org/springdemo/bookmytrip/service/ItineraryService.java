package org.springdemo.bookmytrip.service;

import org.springdemo.bookmytrip.dto.request.ItineraryRequestDTO;
import org.springdemo.bookmytrip.dto.response.ItineraryResponseDTO;
import org.springdemo.bookmytrip.model.Itinerary;

import java.util.List;

public interface ItineraryService {
    ItineraryResponseDTO createItinerary(Long package_id, ItineraryRequestDTO itineraryRequestDTO);
    ItineraryResponseDTO getItineraryById(Long itinerary_id);
    ItineraryResponseDTO updateItinerary(Long id, ItineraryRequestDTO itineraryRequestDTO);
    void deleteItinerary(Long id);
    List<Itinerary> getAllItineraries();
}
