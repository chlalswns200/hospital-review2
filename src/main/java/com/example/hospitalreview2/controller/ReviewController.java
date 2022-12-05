package com.example.hospitalreview2.controller;
import com.example.hospitalreview2.domain.dto.ReviewResponse;
import com.example.hospitalreview2.service.ReviewService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponse> getOneReview(@PathVariable Long id){
        ReviewResponse reviewResponse = reviewService.getOneReview(id);
        return ResponseEntity.ok().body(reviewResponse);
    }
}