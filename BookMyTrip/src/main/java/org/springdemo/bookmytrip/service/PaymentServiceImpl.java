//package org.springdemo.bookmytrip.service;
//
//
//import org.springdemo.bookmytrip.dto.request.PaymentRequestDTO;
//import org.springdemo.bookmytrip.exception.ResourceNotFoundException;
//import org.springdemo.bookmytrip.model.Booking;
//import org.springdemo.bookmytrip.model.Payment;
//import org.springdemo.bookmytrip.repository.PaymentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class PaymentServiceImpl implements PaymentService {
//
//    private final PaymentRepository paymentRepository;
//    private final BookingService bookingService;
//
//    @Autowired
//    public PaymentServiceImpl(PaymentRepository paymentRepository, BookingService bookingService) {
//        this.paymentRepository = paymentRepository;
//        this.bookingService = bookingService;
//    }
//
//    @Override
//    public Payment createPayment(PaymentRequestDTO paymentRequestDTO) {
//        Booking booking = bookingService.getBookingById(paymentRequestDTO.getBookingId());
//
//        Payment payment = new Payment();
//        payment.setBooking(booking);
//        payment.setPaymentDate(paymentRequestDTO.getPaymentDate());
//        payment.setPaymentMethod(paymentRequestDTO.getPaymentMethod());
//        payment.setAmount(paymentRequestDTO.getAmount());
//        payment.setStatus(paymentRequestDTO.getStatus());
//
//        return paymentRepository.save(payment);
//    }
//
//    @Override
//    public Payment getPaymentById(Long id) {
//        return paymentRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Payment not found with id: " + id));
//    }
//
//    @Override
//    public Payment updatePayment(Long id, PaymentRequestDTO paymentRequestDTO) {
//        Payment payment = getPaymentById(id);
//        payment.setPaymentMethod(paymentRequestDTO.getPaymentMethod());
//        payment.setAmount(paymentRequestDTO.getAmount());
//        payment.setStatus(paymentRequestDTO.getStatus());
//        return paymentRepository.save(payment);
//    }
//
//    @Override
//    public void deletePayment(Long id) {
//        Payment payment = getPaymentById(id);
//        paymentRepository.delete(payment);
//    }
//
//    @Override
//    public List<Payment> getAllPayments() {
//        return paymentRepository.findAll();
//    }
//}