package org.springdemo.bookmytrip.repository;

import org.springdemo.bookmytrip.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
