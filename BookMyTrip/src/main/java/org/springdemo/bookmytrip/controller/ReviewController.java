package org.springdemo.bookmytrip.controller;

import jakarta.validation.Valid;
import org.springdemo.bookmytrip.dto.request.ReviewRequestDTO;
import org.springdemo.bookmytrip.dto.response.ReviewResponseDTO;
import org.springdemo.bookmytrip.mapper.response.ReviewResponseMapper;
import org.springdemo.bookmytrip.model.Review;
import org.springdemo.bookmytrip.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer/{id}/review")
public class ReviewController {

    ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @PostMapping("/{review_id}/review")
    public ResponseEntity<ReviewResponseDTO> addReview(@PathVariable Long review_id, @Valid @RequestBody ReviewRequestDTO requestDTO){

        Review review = this.reviewService.createReview(review_id,requestDTO);

        ReviewResponseDTO reviewResponseDTO =  ReviewResponseMapper.toDTO(review);

        return ResponseEntity.ok(reviewResponseDTO);

    }
}
