package com.example.hospitalreview2.service;

import com.example.hospitalreview2.domain.Hospital;
import com.example.hospitalreview2.domain.User;
import com.example.hospitalreview2.domain.Visit;
import com.example.hospitalreview2.domain.dto.VisitCreateRequest;
import com.example.hospitalreview2.exception.ErrorCode;
import com.example.hospitalreview2.exception.HospitalReviewAppException;
import com.example.hospitalreview2.repository.HospitalRepository;
import com.example.hospitalreview2.repository.UserRepository;
import com.example.hospitalreview2.repository.VisitRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;
    private final HospitalRepository hospitalRepository;
    private final UserRepository userRepository;
    public void createVisit(VisitCreateRequest visitCreateRequest, String userName) {
        User user = userRepository.findByUserName(userName).orElseThrow(() -> new HospitalReviewAppException(ErrorCode.NOT_FOUND, "해당하는 USER없음"));
        Hospital hospital = hospitalRepository.findById(visitCreateRequest.getHospitalId()).orElseThrow(() -> new HospitalReviewAppException(ErrorCode.NOT_FOUND, "해당하는 병원 없음"));

        Visit build = Visit.builder()
                .localDate(LocalDate.now())
                .disease(visitCreateRequest.getDiseaseName())
                .amount(visitCreateRequest.getAmount())
                .user(user)
                .hospital(hospital)
                .build();

        visitRepository.save(build);
    }
}
