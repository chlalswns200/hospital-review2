package com.example.hospitalreview2.service;

import com.example.hospitalreview2.domain.Hospital;
import com.example.hospitalreview2.domain.dto.HospitalResponse;
import com.example.hospitalreview2.repository.HospitalRepository;
import com.example.hospitalreview2.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;
    private final ReviewRepository reviewRepository;

    public HospitalResponse getHospitalWithReviews(Long id){
        Optional<Hospital> opHospital = hospitalRepository.findById(id);
        Hospital hospital = opHospital.get();
        return HospitalResponse.builder()
                .id(hospital.getId())
                .hospitalName(hospital.getHospitalName())
                .roadNameAddress(hospital.getRoadNameAddress())
                .build();
    }

}