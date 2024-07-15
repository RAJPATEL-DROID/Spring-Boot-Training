package org.springdemo.bookmytrip.repository;

import org.springdemo.bookmytrip.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
