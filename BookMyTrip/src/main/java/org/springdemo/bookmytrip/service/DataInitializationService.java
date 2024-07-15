package org.springdemo.bookmytrip.service;

import jakarta.annotation.PostConstruct;
import org.springdemo.bookmytrip.model.*;
import org.springdemo.bookmytrip.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class DataInitializationService {

    @Autowired
    TripPackageRepository tripPackageRepository;

    @Autowired
    TripSegmentRepository tripSegmentRepository;

    @Autowired
    ItineraryRepository itineraryRepository;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    private CustomerRepository customerRepository;


    @PostConstruct
    @Transactional
    public void initialiseData(){
        Location amd = new Location("Ahmedabad","India","JNP");

        Location ben = new Location("Bengaluru","India","BLR");
        Location del = new Location("Delhi","India","IGN");

        Location mum = new Location("Mumbai","India","MST");

        locationRepository.saveAll(Arrays.asList(amd,ben,del));

        TripPackage westernIndiaTrip = new TripPackage();

        westernIndiaTrip.setTripName("Western Beauty");

        westernIndiaTrip.setDescription("This Trip covers West India");

        westernIndiaTrip.setPrice(BigDecimal.valueOf(1500.00));

        tripPackageRepository.save(westernIndiaTrip);

        createItinerary(westernIndiaTrip,LocalDate.of(2024,6,10),LocalDate.of(2024,6,13),del,mum,del);

        createItinerary(westernIndiaTrip,LocalDate.of(2024,7,15),LocalDate.of(2024,7,18),ben,amd,ben);

        Customer customer = new Customer();

        customer.setName("Dev");
        customer.setEmail("dev@gmail.com");
        customerRepository.save(customer);

        createReview(westernIndiaTrip,customer,BigDecimal.valueOf(3.2),"Nothing Much To See");

    }

    private void createItinerary(TripPackage tripPackage, LocalDate startDate,LocalDate endDate, Location location1,Location location2,Location location3){
        Itinerary itinerary = new Itinerary();

        locationRepository.saveAll(Arrays.asList(location1,location2,location3));

        itinerary.setStartDate(startDate);
        itinerary.setLastDate(endDate);
        itinerary.setTripPackage(tripPackage);

        itineraryRepository.save(itinerary);

        Flight flight1= new Flight(itinerary,SegmentType.FLIGHT,"AA01",startDate.atTime(10,0),startDate.atTime(20,15),location1,location2);

        Hotel hotel1 = new Hotel(itinerary,SegmentType.HOTEL,"The Taj","India Gate,Mumbai",location2,startDate,endDate);

        Flight flight2 = new Flight(itinerary,SegmentType.FLIGHT,"AB01",endDate.atTime(13,25),endDate.atTime(16,20),location2,location3);

        flightRepository.saveAll(Arrays.asList(flight1,flight2));

        hotelRepository.save(hotel1);

        itinerary.getTripSegments().addAll(List.of(flight1,hotel1,flight2));


        itineraryRepository.save(itinerary);
    }

    private void createReview(TripPackage tripPackage,Customer customer,BigDecimal rating,String comment){
        Review review = new Review(rating,comment,tripPackage,customer);

        reviewRepository.save(review);
    }



}
