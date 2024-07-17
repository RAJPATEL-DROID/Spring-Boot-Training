//package org.springdemo.bookmytrip.service;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.criteria.CriteriaQuery;
//import jakarta.persistence.criteria.Predicate;
//import jakarta.persistence.criteria.Root;
//import org.springdemo.bookmytrip.dto.request.BookingRequestDTO;
//import org.springdemo.bookmytrip.dto.response.CustomerResponseDTO;
//import org.springdemo.bookmytrip.enums.BookingStatus;
//import org.springdemo.bookmytrip.exception.ResourceNotFoundException;
//import org.springdemo.bookmytrip.mapper.request.CustomerRequestMapper;
//import org.springdemo.bookmytrip.mapper.response.CustomerResponseMapper;
//import org.springdemo.bookmytrip.mapper.response.TripPackageResponseMapper;
//import org.springdemo.bookmytrip.model.Booking;
//import org.springdemo.bookmytrip.model.TripPackage;
//import org.springdemo.bookmytrip.repository.BookingRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//public class BookingServiceImpl implements BookingService{
//
//
//    private final BookingRepository bookingRepository;
//    private final CustomerService customerService;
//    private final TripPackageService tripPackageService;
//    private final EntityManager entityManager;
//
//    @Autowired
//    public BookingServiceImpl(BookingRepository bookingRepository, CustomerService customerService,
//                              TripPackageService tripPackageService, EntityManager entityManager) {
//        this.bookingRepository = bookingRepository;
//        this.customerService = customerService;
//        this.tripPackageService = tripPackageService;
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    public Booking createBooking(BookingRequestDTO bookingRequestDTO) {
//        CustomerResponseDTO customer = customerService.getCustomerById(bookingRequestDTO.getCustomerId());
//        TripPackage tripPackage = TripPackageResponseMapper.toEntity(tripPackageService.getTripPackageById(bookingRequestDTO.getTravelPackageId()));
//
//        Booking booking = new Booking();
//        booking.setCustomer(CustomerResponseMapper.toEntity(customer));
//        booking.setTripPackage(tripPackage);
//        booking.setBookingDate(bookingRequestDTO.getBookingDate());
//        booking.setStatus(bookingRequestDTO.getStatus());
//
//        return bookingRepository.save(booking);
//    }
//
//    @Override
//    public Booking getBookingById(Long id) {
//        return bookingRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));
//    }
//
//    @Override
//    public Booking updateBooking(Long id, BookingRequestDTO bookingRequestDTO) {
//        Booking booking = getBookingById(id);
//        booking.setStatus(bookingRequestDTO.getStatus());
//        return bookingRepository.save(booking);
//    }
//
//    @Override
//    public void deleteBooking(Long id) {
//        Booking booking = getBookingById(id);
//        bookingRepository.delete(booking);
//    }
//
//    @Override
//    public List<Booking> getAllBookings() {
//        return bookingRepository.findAll();
//    }
//
//    @Override
//    public List<Booking> getBookingsByCustomerId(Long customerId) {
//        return bookingRepository.findByCustomerId(customerId);
//    }
//
//
//    @Override
//    public List<Booking> getBookingsWithDetailsForCustomer(Long customerId) {
//        return bookingRepository.findBookingsWithDetailsForCustomer(customerId);
//    }
//
//    @Override
//    public List<Booking> getBookingsByDateRangeAndStatus(LocalDateTime startDate, LocalDateTime endDate, BookingStatus status) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Booking> query = cb.createQuery(Booking.class);
//        Root<Booking> root = query.from(Booking.class);
//
//        Predicate datePredicate = cb.between(root.get("bookingDate"), startDate, endDate);
//        Predicate statusPredicate = cb.equal(root.get("status"), status);
//
//        query.select(root).where(cb.and(datePredicate, statusPredicate));
//
//        return entityManager.createQuery(query).getResultList();
//    }
//}
