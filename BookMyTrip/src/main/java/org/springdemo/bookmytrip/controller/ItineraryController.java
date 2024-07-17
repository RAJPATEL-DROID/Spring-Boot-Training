//package org.springdemo.bookmytrip.controller;
//
//import org.springdemo.bookmytrip.dto.request.ItineraryRequestDTO;
//import org.springdemo.bookmytrip.dto.response.ItineraryResponseDTO;
//import org.springdemo.bookmytrip.service.ItineraryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/travel-package/{packageId}/itinerary")
//public class ItineraryController {
//
//    @Autowired
//    ItineraryService itineraryService;
//
//    @PostMapping
//    public ResponseEntity<ItineraryResponseDTO> createItinerary(@PathVariable Long packageId, @RequestBody ItineraryRequestDTO itineraryRequestDTO){
//
//        ItineraryResponseDTO itineraryResponse = itineraryService.createItinerary(packageId, itineraryRequestDTO);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(itineraryResponse);
//
//    }
//}
