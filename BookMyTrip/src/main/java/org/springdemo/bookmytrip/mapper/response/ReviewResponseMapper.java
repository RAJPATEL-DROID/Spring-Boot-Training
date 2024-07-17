package org.springdemo.bookmytrip.mapper.response;

import org.springdemo.bookmytrip.dto.request.ReviewRequestDTO;
import org.springdemo.bookmytrip.dto.response.ReviewResponseDTO;
import org.springdemo.bookmytrip.model.Customer;
import org.springdemo.bookmytrip.model.Review;
import org.springdemo.bookmytrip.model.TripPackage;

public class ReviewResponseMapper {

    public static ReviewResponseDTO toDTO(Review review) {
        if (review == null) {
            return null;
        }

        ReviewResponseDTO dto = new ReviewResponseDTO();
        dto.setId(review.getId());
        dto.setCustomerId(review.getCustomer() != null ? review.getCustomer().getId() : null);
        dto.setTripPackageId(review.getTripPackage() != null ? review.getTripPackage().getId() : null);
        dto.setRating(review.getRating());
        dto.setComment(review.getComment());
        dto.setReviewDate(review.getReviewDate());

        return dto;
    }

    public static Review toEntity(ReviewResponseDTO dto) {
        if (dto == null) {
            return null;
        }

        Review review = new Review();
        review.setId(dto.getId());
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