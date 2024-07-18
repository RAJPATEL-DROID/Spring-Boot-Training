package org.springdemo.bookmytrip.mapper.request;

import org.springdemo.bookmytrip.dto.request.ReviewRequestDTO;
import org.springdemo.bookmytrip.dto.response.ReviewResponseDTO;
import org.springdemo.bookmytrip.model.Review;
import org.springdemo.bookmytrip.model.Customer;
import org.springdemo.bookmytrip.model.TripPackage;

public class ReviewRequestMapper {


    public static Review toEntity(ReviewRequestDTO dto) {
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