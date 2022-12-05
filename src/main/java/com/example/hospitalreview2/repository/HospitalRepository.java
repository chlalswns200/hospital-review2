package com.example.hospitalreview2.repository;


import com.example.hospitalreview2.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital,Long> {
}
