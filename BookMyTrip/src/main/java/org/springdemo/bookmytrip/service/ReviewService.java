package org.springdemo.bookmytrip.service;

import org.springdemo.bookmytrip.dto.request.ReviewRequestDTO;
import org.springdemo.bookmytrip.model.Review;

import java.util.List;

public interface ReviewService {
    Review createReview(Long id, ReviewRequestDTO reviewRequestDTO);
    Review getReviewById(Long id);
    Review updateReview(Long id, ReviewRequestDTO reviewRequestDTO);
    void deleteReview(Long id);
    List<Review> getAllReviews();
    List<Review> getReviewsByTripPackageId(Long travelPackageId);
}
