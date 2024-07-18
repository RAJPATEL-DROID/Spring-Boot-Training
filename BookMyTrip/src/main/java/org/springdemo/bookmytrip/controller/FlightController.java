package org.springdemo.bookmytrip.controller;

import jakarta.validation.Valid;
import org.springdemo.bookmytrip.dto.request.FlightSegmentRequestDTO;
import org.springdemo.bookmytrip.dto.response.FlightSegmentResponseDTO;
import org.springdemo.bookmytrip.mapper.request.FlightSegmentRequestMapper;
import org.springdemo.bookmytrip.mapper.response.FlightSegmentResponseMapper;
import org.springdemo.bookmytrip.model.FlightSegment;
import org.springdemo.bookmytrip.service.FlightSegmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flight")
public class FlightController {


    FlightSegmentService flightSegmentService;

    public FlightController(FlightSegmentService flightSegmentService) {
        this.flightSegmentService = flightSegmentService;
    }

    @GetMapping
    public ResponseEntity<List<FlightSegmentResponseDTO>> getAllFlights(){

        List<FlightSegment> flightSegments = flightSegmentService.getAllFlightSegment();

        System.out.println(flightSegments);

        List<FlightSegmentResponseDTO> flightSegmentResponseDTOS= flightSegments.stream().map(FlightSegmentResponseMapper::toDTO).toList();

        return ResponseEntity.ok(flightSegmentResponseDTOS);

    }

    @PostMapping
    public ResponseEntity<FlightSegmentResponseDTO> addFlight(@Valid @RequestBody FlightSegmentRequestDTO requestDTO){

        FlightSegment flightSegment = FlightSegmentRequestMapper.toEntity(requestDTO);

        FlightSegment responseFlight = flightSegmentService.addFlightSegment(flightSegment);

        FlightSegmentResponseDTO flightSegmentResponseDTO = FlightSegmentResponseMapper.toDTO(responseFlight);

        return ResponseEntity.status(HttpStatus.CREATED).body(flightSegmentResponseDTO);

    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightSegmentResponseDTO> getFlight(@PathVariable Long id) {
        FlightSegment flightSegment =  flightSegmentService.getFlightSegment(id);

        FlightSegmentResponseDTO responseDTO = FlightSegmentResponseMapper.toDTO(flightSegment);

        return ResponseEntity.ok(responseDTO);

    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightSegmentResponseDTO> updateFlight(@PathVariable Long id,@Valid @RequestBody FlightSegmentRequestDTO flightSegmentRequestDTO)
    {
        FlightSegment flightSegment = FlightSegmentRequestMapper.toEntity(flightSegmentRequestDTO);

        FlightSegment updatedFlight = flightSegmentService.updateFlightSegment(id,flightSegment);

        FlightSegmentResponseDTO flightSegmentResponseDTO = FlightSegmentResponseMapper.toDTO(updatedFlight);

        return ResponseEntity.ok(flightSegmentResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id){

        flightSegmentService.deleteFlightSegment(id);

        return ResponseEntity.noContent().build();
    }


}
