package com.example.hospitalreview2.repository;

import com.example.hospitalreview2.domain.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit,Long> {
    List<Visit> findByUserId(Long id);
}
