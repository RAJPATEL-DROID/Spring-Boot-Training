//package org.springdemo.bookmytrip.service;
//
//
//import org.springdemo.bookmytrip.dto.request.ItineraryRequestDTO;
//import org.springdemo.bookmytrip.dto.request.TripPackageRequestDTO;
//import org.springdemo.bookmytrip.dto.response.ItineraryResponseDTO;
//import org.springdemo.bookmytrip.dto.response.TripPackageResponseDTO;
//import org.springdemo.bookmytrip.exception.ResourceNotFoundException;
//import org.springdemo.bookmytrip.mapper.request.ItineraryRequestMapper;
//import org.springdemo.bookmytrip.mapper.response.ItineraryResponseMapper;
//import org.springdemo.bookmytrip.mapper.response.TripPackageResponseMapper;
//import org.springdemo.bookmytrip.model.Itinerary;
//import org.springdemo.bookmytrip.model.TripPackage;
//import org.springdemo.bookmytrip.repository.ItineraryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ItineraryServiceImpl implements ItineraryService {
//
//    private final ItineraryRepository itineraryRepository;
//    private final TripPackageService tripPackageService;
//
//    @Autowired
//    public ItineraryServiceImpl(ItineraryRepository itineraryRepository, TripPackageService tripPackageService) {
//        this.itineraryRepository = itineraryRepository;
//        this.tripPackageService =  tripPackageService;
//    }
//
//    @Override
//    public ItineraryResponseDTO createItinerary(Long package_id, ItineraryRequestDTO itineraryRequestDTO) {
//        TripPackageResponseDTO travelPackage = tripPackageService.getTripPackageById(itineraryRequestDTO.getTravelPackageId());
//
//        Itinerary itinerary = new Itinerary();
//        itinerary.setTripPackage(TripPackageResponseMapper.toEntity(travelPackage));
//        itinerary.setStartDate(itineraryRequestDTO.getStartDate());
//        itinerary.setEndDate(itineraryRequestDTO.getEndDate());
//
//        Itinerary itinerary1 =  itineraryRepository.save(itinerary);
//
//        return ItineraryResponseMapper.toDTO(itinerary1);
//    }
//
//    @Override
//    public ItineraryResponseDTO getItineraryById(Long itinerary_id) {
//
//        return itineraryRepository.findById(itinerary_id).map(ItineraryResponseMapper::toDTO)
//                .orElseThrow(() -> new ResourceNotFoundException("Itinerary not found with id: " + itinerary_id));
//    }
//
//    @Override
//    public ItineraryResponseDTO updateItinerary(Long id, ItineraryRequestDTO itineraryRequestDTO) {
//        Itinerary itinerary = ItineraryResponseMapper.toEntity(getItineraryById(id));
//
//        itinerary.setStartDate(itineraryRequestDTO.getStartDate());
//
//        itinerary.setEndDate(itineraryRequestDTO.getEndDate());
//
//        return ItineraryResponseMapper.toDTO(itineraryRepository.save(itinerary));
//    }
//
//    @Override
//    public void deleteItinerary(Long id) {
//
//        itineraryRepository.deleteById(id);
//
//    }
//
//    @Override
//    public List<Itinerary> getAllItineraries() {
//        return itineraryRepository.findAll();
//    }
//}
