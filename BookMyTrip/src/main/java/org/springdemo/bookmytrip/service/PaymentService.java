package org.springdemo.bookmytrip.service;

import org.springdemo.bookmytrip.dto.request.PaymentRequestDTO;
import org.springdemo.bookmytrip.model.Payment;

import java.util.List;

public interface PaymentService {
        Payment createPayment(PaymentRequestDTO paymentRequestDTO);
        Payment getPaymentById(Long id);
        Payment updatePayment(Long id, PaymentRequestDTO paymentRequestDTO);
        void deletePayment(Long id);
        List<Payment> getAllPayments();
}
