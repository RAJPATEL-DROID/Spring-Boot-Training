package org.springdemo.bookmytrip.controller;

import org.springdemo.bookmytrip.dto.request.ItineraryRequestDTO;
import org.springdemo.bookmytrip.dto.response.ItineraryResponseDTO;
import org.springdemo.bookmytrip.mapper.request.ItineraryRequestMapper;
import org.springdemo.bookmytrip.mapper.response.ItineraryResponseMapper;
import org.springdemo.bookmytrip.model.Itinerary;
import org.springdemo.bookmytrip.service.ItineraryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itinerary")
public class ItineraryController {

    final ItineraryService itineraryService;

    public ItineraryController(ItineraryService itineraryService) {
        this.itineraryService = itineraryService;
    }

    @PostMapping
    public ResponseEntity<ItineraryResponseDTO> createItinerary(@RequestBody ItineraryRequestDTO itineraryRequestDTO){

        Itinerary itinerary = ItineraryRequestMapper.toEntity(itineraryRequestDTO);

        Itinerary itineraryResponse = itineraryService.createItinerary(itinerary);

        ItineraryResponseDTO itineraryResponseDTO = ItineraryResponseMapper.toDTO(itineraryResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(itineraryResponseDTO);

    }

    @GetMapping
    public ResponseEntity<List<ItineraryResponseDTO>> getAllItinerary(){
        List<Itinerary> itineraries = itineraryService.getAllItineraries();

        List<ItineraryResponseDTO> itineraryResponseDTOS= itineraries.stream().map(ItineraryResponseMapper::toDTO).toList();

        return ResponseEntity.ok(itineraryResponseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItineraryResponseDTO> getItinerary(@PathVariable Long id)
    {
        Itinerary itinerary = itineraryService.getItineraryById(id);

        ItineraryResponseDTO itineraryResponseDTO = ItineraryResponseMapper.toDTO(itinerary);

        return ResponseEntity.ok(itineraryResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItineraryResponseDTO> updateItinerary(@PathVariable Long id, @RequestBody ItineraryRequestDTO itineraryRequestDTO){
        Itinerary itinerary= ItineraryRequestMapper.toEntity(itineraryRequestDTO);

        Itinerary itinerary1= itineraryService.updateItinerary(id,itinerary);

        ItineraryResponseDTO itineraryResponseDTO = ItineraryResponseMapper.toDTO(itinerary1);

        return ResponseEntity.ok(itineraryResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItinerary(@PathVariable Long id)
    {
        itineraryService.deleteItinerary(id);

        return ResponseEntity.noContent().build();
    }

}
