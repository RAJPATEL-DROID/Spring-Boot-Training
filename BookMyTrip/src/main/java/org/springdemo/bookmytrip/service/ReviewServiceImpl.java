package org.springdemo.bookmytrip.service;

import org.springdemo.bookmytrip.dto.request.ReviewRequestDTO;
import org.springdemo.bookmytrip.exception.ResourceNotFoundException;
import org.springdemo.bookmytrip.model.Customer;
import org.springdemo.bookmytrip.model.Review;
import org.springdemo.bookmytrip.model.TripPackage;
import org.springdemo.bookmytrip.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final CustomerService customerService;
    private final TripPackageService tripPackageService;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, CustomerService customerService, TripPackageService tripPackageService) {
        this.reviewRepository = reviewRepository;
        this.customerService = customerService;
        this.tripPackageService = tripPackageService;
    }

    @Override
    public Review createReview(Long id,ReviewRequestDTO reviewRequestDTO) {

        Customer customer = customerService.getCustomerById(id);

        TripPackage travelPackage = tripPackageService.getTripPackageById(reviewRequestDTO.getTripPackageId());


        Review review = new Review();

        review.setCustomer(customer);

        review.setTripPackage(travelPackage);

        review.setRating(reviewRequestDTO.getRating());

        review.setComment(reviewRequestDTO.getComment());

        review.setReviewDate(reviewRequestDTO.getReviewDate());

        return reviewRepository.save(review);
    }

    @Override
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + id));
    }

    @Override
    public Review updateReview(Long id, ReviewRequestDTO reviewRequestDTO) {
        Review review = getReviewById(id);
        review.setRating(reviewRequestDTO.getRating());
        review.setComment(reviewRequestDTO.getComment());
        return reviewRepository.save(review);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> getReviewsByTripPackageId(Long travelPackageId) {
        return reviewRepository.findByTripPackageId(travelPackageId);
    }
}
