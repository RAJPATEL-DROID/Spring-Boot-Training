package org.springdemo.bookmytrip.repository;

import org.springdemo.bookmytrip.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    List<Review> findByTripPackageId(Long tripPackageId);
}
