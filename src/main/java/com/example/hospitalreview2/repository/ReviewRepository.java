package com.example.hospitalreview2.repository;

import com.example.hospitalreview2.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findAllByHospitalId(Long id);
}
