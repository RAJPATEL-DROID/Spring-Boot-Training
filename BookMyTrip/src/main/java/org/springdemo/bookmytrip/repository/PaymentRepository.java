package org.springdemo.bookmytrip.repository;

import org.springdemo.bookmytrip.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
