package org.springdemo.bookmytrip.service.implementation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springdemo.bookmytrip.enums.BookingStatus;
import org.springdemo.bookmytrip.exception.ResourceNotFoundException;
import org.springdemo.bookmytrip.mapper.response.CustomerResponseMapper;
import org.springdemo.bookmytrip.model.Booking;
import org.springdemo.bookmytrip.model.Customer;
import org.springdemo.bookmytrip.model.TripPackage;
import org.springdemo.bookmytrip.repository.BookingRepository;
import org.springdemo.bookmytrip.repository.CustomerRepository;
import org.springdemo.bookmytrip.service.BookingService;
import org.springdemo.bookmytrip.service.CustomerService;
import org.springdemo.bookmytrip.service.TripPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {


    private final BookingRepository bookingRepository;
    private final CustomerService customerService;
    private final TripPackageService tripPackageService;
    private final EntityManager entityManager;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, CustomerService customerService,
                              TripPackageService tripPackageService, EntityManager entityManager, CustomerRepository customerRepository) {
        this.bookingRepository = bookingRepository;
        this.customerService = customerService;
        this.tripPackageService = tripPackageService;
        this.entityManager = entityManager;
    }

    @Override
    public Booking createBooking(Booking booking) {

        Long customerId = booking.getCustomer().getId();

        Customer customer = customerService.getCustomerById(customerId);

        booking.setCustomer(customer);

        TripPackage tripPackage = tripPackageService.getTripPackageById(booking.getTripPackage().getId());

        booking.setTripPackage(tripPackage);

        return bookingRepository.save(booking);
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));
    }

    @Override
    public Booking updateBooking(Long id, Booking newBooking) {

        Booking booking = getBookingById(id);

        booking.setBookingDate(newBooking.getBookingDate());

        booking.setCustomer(customerService.getCustomerById(newBooking.getCustomer().getId()));

        booking.setTripPackage(tripPackageService.getTripPackageById(newBooking.getTripPackage().getId()));

        return bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(Long id) {

        Booking booking = getBookingById(id);

        bookingRepository.delete(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> getBookingsByCustomerId(Long customerId) {
        return bookingRepository.findByCustomerId(customerId);
    }

//
//    @Override
//    public List<Booking> getBookingsWithDetailsForCustomer(Long customerId) {
//        return bookingRepository.findBookingsWithDetailsForCustomer(customerId);
//    }

    @Override
    public List<Booking> getBookingsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Booking> query = cb.createQuery(Booking.class);
        Root<Booking> root = query.from(Booking.class);

        Predicate datePredicate = cb.between(root.get("bookingDate"), startDate, endDate);

        query.select(root).where(datePredicate);

        return entityManager.createQuery(query).getResultList();
    }
}
