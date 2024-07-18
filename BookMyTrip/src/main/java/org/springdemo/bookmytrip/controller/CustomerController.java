package org.springdemo.bookmytrip.controller;

import org.springdemo.bookmytrip.dto.request.BookingRequestDTO;
import org.springdemo.bookmytrip.dto.request.CustomerRequestDTO;
import org.springdemo.bookmytrip.dto.response.BookingResponseDTO;
import org.springdemo.bookmytrip.dto.response.CustomerResponseDTO;
import org.springdemo.bookmytrip.mapper.request.BookingRequestMapper;
import org.springdemo.bookmytrip.mapper.request.CustomerRequestMapper;
import org.springdemo.bookmytrip.mapper.response.BookingResponseMapper;
import org.springdemo.bookmytrip.mapper.response.CustomerResponseMapper;
import org.springdemo.bookmytrip.model.Booking;
import org.springdemo.bookmytrip.model.Customer;
import org.springdemo.bookmytrip.service.BookingService;
import org.springdemo.bookmytrip.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final BookingService bookingService;

    @Autowired
    public CustomerController(CustomerService customerService, BookingService bookingService) {
        this.customerService = customerService;
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> createCustomer(@Valid @RequestBody CustomerRequestDTO customerRequestDTO) {
        Customer customer = CustomerRequestMapper.toEntity(customerRequestDTO);

        Customer responseCustomer = this.customerService.createCustomer(customer);

        CustomerResponseDTO customerResponseDTO = CustomerResponseMapper.toDTO(responseCustomer);

        return ResponseEntity.status(HttpStatus.CREATED).body(customerResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> getCustomer(@PathVariable Long id) {
        Customer responseCustomer = customerService.getCustomerById(id);

        CustomerResponseDTO customerResponseDTO = CustomerResponseMapper.toDTO(responseCustomer);

        return ResponseEntity.ok(customerResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> updateCustomer(@PathVariable Long id, @Valid @RequestBody CustomerRequestDTO customerRequestDTO) {

        Customer customer = CustomerRequestMapper.toEntity(customerRequestDTO);

        Customer responseCustomer = this.customerService.updateCustomer(id, customer);

        CustomerResponseDTO customerResponseDTO = CustomerResponseMapper.toDTO(responseCustomer);

        return ResponseEntity.ok(customerResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Object> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();

        if(customers.isEmpty()){
            return ResponseEntity.ok("No Customer Exists");
        }

        List<CustomerResponseDTO> customerResponseDTOS = customers.stream().map(CustomerResponseMapper::toDTO).toList();

        return ResponseEntity.ok(customerResponseDTOS);
    }

    @GetMapping("/{customerId}/booking")
    public ResponseEntity<List<BookingResponseDTO>> getBookings(@PathVariable Long customerId){

        List<Booking> bookingList = bookingService.getBookingsByCustomerId(customerId);

        List<BookingResponseDTO> bookingResponseDTOS=  bookingList.stream().map(BookingResponseMapper::toDTO).toList();

        return ResponseEntity.ok(bookingResponseDTOS);
    }

    @PostMapping("/{customerId}/booking")
    public ResponseEntity<BookingResponseDTO> addBooking(@Valid @RequestBody BookingRequestDTO requestDTO){
        Booking booking = BookingRequestMapper.toEntity(requestDTO);

        Booking newBooking = bookingService.createBooking(booking);

        BookingResponseDTO bookingResponseDTO = BookingResponseMapper.toDTO(newBooking);

        return ResponseEntity.ok(bookingResponseDTO);
    }

}