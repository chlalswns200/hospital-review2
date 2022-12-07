package com.example.hospitalreview2.controller;

import com.example.hospitalreview2.domain.dto.HospitalResponse;
import com.example.hospitalreview2.domain.dto.ReviewAddRequest;
import com.example.hospitalreview2.domain.dto.ReviewAddResponse;
import com.example.hospitalreview2.domain.dto.ReviewResponse;
import com.example.hospitalreview2.service.HospitalService;
import com.example.hospitalreview2.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hospitals")
@RequiredArgsConstructor
@Slf4j
public class HospitalController {

    private final HospitalService hospitalService;
    private final ReviewService reviewService;

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> getHospitalWithReviews(@PathVariable Long id){
        List<ReviewResponse> allReviews = reviewService.getAllByHospital(id);
        HospitalResponse hospitalResponse = hospitalService.getHospitalWithReviews(id);
        hospitalResponse.setReviews(allReviews);
        return ResponseEntity.ok().body(hospitalResponse);
    }
    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<ReviewResponse>> getAllReviewsByHospital(@PathVariable Long id){
        List<ReviewResponse> allReviews = reviewService.getAllByHospital(id);
        return ResponseEntity.ok().body(allReviews);
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewAddResponse> createReview(@PathVariable Long id, @RequestBody ReviewAddRequest request, Authentication authentication){
        log.info("isAuthenticated:{},name:{},principle:{},authorities:{}",
                authentication.isAuthenticated(), authentication.getName(), authentication.getPrincipal().toString(),authentication.getAuthorities().toString());
        return ResponseEntity.ok().body(reviewService.add(request, id));
    }
}
