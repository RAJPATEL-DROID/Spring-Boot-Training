package org.springdemo.bookmytrip.mapper;

import org.springdemo.bookmytrip.model.Review;
import org.springdemo.bookmytrip.model.Customer;
import org.springdemo.bookmytrip.model.TripPackage;

public class ReviewMapper {

    public static ReviewDTO toDTO(Review review) {
        if (review == null) {
            return null;
        }

        ReviewDTO dto = new ReviewDTO();

        dto.setCustomerId(review.getCustomer() != null ? review.getCustomer().getId() : null);
        dto.setTripPackageId(review.getTripPackage() != null ? review.getTripPackage().getId() : null);
        dto.setRating(review.getRating());
        dto.setComment(review.getComment());
        dto.setReviewDate(review.getReviewDate());

        return dto;
    }

    public static Review toEntity(ReviewDTO dto) {
        if (dto == null) {
            return null;
        }

        Review review = new Review();

        review.setRating(dto.getRating());
        review.setComment(dto.getComment());
        review.setReviewDate(dto.getReviewDate());

        if (dto.getCustomerId() != null) {
            Customer customer = new Customer();
            customer.setId(dto.getCustomerId());
            review.setCustomer(customer);
        }

        if (dto.getTripPackageId() != null) {
            TripPackage tripPackage = new TripPackage();
            tripPackage.setId(dto.getTripPackageId());
            review.setTripPackage(tripPackage);
        }

        return review;
    }
}