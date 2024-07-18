package org.springdemo.bookmytrip.controller;

import jakarta.validation.Valid;
import org.springdemo.bookmytrip.dto.request.HotelSegmentRequestDTO;
import org.springdemo.bookmytrip.dto.response.HotelSegmentResponseDTO;
import org.springdemo.bookmytrip.mapper.request.HotelSegmentRequestMapper;
import org.springdemo.bookmytrip.mapper.response.HotelSegmentResponseMapper;
import org.springdemo.bookmytrip.model.HotelSegment;
import org.springdemo.bookmytrip.service.HotelSegmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    HotelSegmentService hotelSegmentService;

    public HotelController(HotelSegmentService hotelSegmentService) {
        this.hotelSegmentService = hotelSegmentService;
    }

    @GetMapping
    public ResponseEntity<List<HotelSegmentResponseDTO>> getAllFlights(){

        List<HotelSegment> hotelSegments = hotelSegmentService.getAllHotelSegments();

        System.out.println(hotelSegments);

        List<HotelSegmentResponseDTO> hotelSegmentResponseDTOS= hotelSegments.stream().map(HotelSegmentResponseMapper::toDTO).toList();

        return ResponseEntity.ok(hotelSegmentResponseDTOS);

    }

    @PostMapping
    public ResponseEntity<HotelSegmentResponseDTO> addFlight(@Valid @RequestBody HotelSegmentRequestDTO requestDTO){

        HotelSegment hotelSegment = HotelSegmentRequestMapper.toEntity(requestDTO);

        HotelSegment responseHotel = hotelSegmentService.addHotelSegment(hotelSegment);

        HotelSegmentResponseDTO hotelSegmentResponseDTO = HotelSegmentResponseMapper.toDTO(responseHotel);

        return ResponseEntity.status(HttpStatus.CREATED).body(hotelSegmentResponseDTO);

    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelSegmentResponseDTO> getFlight(@PathVariable Long id) {
        HotelSegment hotelSegment =  hotelSegmentService.getHotelSegment(id);

        HotelSegmentResponseDTO responseDTO = HotelSegmentResponseMapper.toDTO(hotelSegment);

        return ResponseEntity.ok(responseDTO);

    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelSegmentResponseDTO> updateFlight(@PathVariable Long id,@Valid @RequestBody HotelSegmentRequestDTO hotelSegmentRequestDTO)
    {
        HotelSegment hotelSegment = HotelSegmentRequestMapper.toEntity(hotelSegmentRequestDTO);

        HotelSegment updatedFlight = hotelSegmentService.updateHotelSegment(id,hotelSegment);

        HotelSegmentResponseDTO hotelSegmentResponseDTO = HotelSegmentResponseMapper.toDTO(updatedFlight);

        return ResponseEntity.ok(hotelSegmentResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id){
        hotelSegmentService.deleteHotelSegment(id);

        return ResponseEntity.noContent().build();
    }

}
