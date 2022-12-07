package com.example.hospitalreview2.repository;

import com.example.hospitalreview2.domain.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit,Long> {
}
