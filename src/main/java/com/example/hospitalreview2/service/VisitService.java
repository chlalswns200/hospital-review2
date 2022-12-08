package com.example.hospitalreview2.service;

import com.example.hospitalreview2.domain.Hospital;
import com.example.hospitalreview2.domain.User;
import com.example.hospitalreview2.domain.Visit;
import com.example.hospitalreview2.domain.dto.VisitCreateRequest;
import com.example.hospitalreview2.domain.dto.VisitListOneUserResponse;
import com.example.hospitalreview2.domain.dto.VisitListResponse;
import com.example.hospitalreview2.exception.ErrorCode;
import com.example.hospitalreview2.exception.HospitalReviewAppException;
import com.example.hospitalreview2.repository.HospitalRepository;
import com.example.hospitalreview2.repository.UserRepository;
import com.example.hospitalreview2.repository.VisitRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

    public List<VisitListResponse> getList() {
        List<Visit> all = visitRepository.findAll();
        List<VisitListResponse> visitAllList = new ArrayList<>();
        for (Visit visit : all) {
            VisitListResponse vlr = VisitListResponse.builder()
                    .userName(visit.getUser().getUserName())
                    .hospitalName(visit.getHospital().getHospitalName())
                    .diseaseName(visit.getDisease())
                    .localDate(visit.getLocalDate())
                    .amount(visit.getAmount())
                    .build();
            visitAllList.add(vlr);
        }
        return visitAllList;
    }

    public List<VisitListOneUserResponse> findOneUserList(Long id) {
        List<Visit> byUserId = visitRepository.findByUserId(id);
        List<VisitListOneUserResponse> visitAllList = new ArrayList<>();
        for (Visit visit : byUserId) {
            VisitListOneUserResponse vlr = VisitListOneUserResponse.builder()
                    .hospitalName(visit.getHospital().getHospitalName())
                    .diseaseName(visit.getDisease())
                    .localDate(visit.getLocalDate())
                    .amount(visit.getAmount())
                    .build();
            visitAllList.add(vlr);
        }
        return visitAllList;
    }
    /*
    public List<VisitResponse> findAllByPage(Pageable pageable) {
        Page<Visit> visits = visitRepository.findAll(pageable);

        // Visits --> VisitResponse
        return visits.stream()
                .map(Visit::toResponse)
                .collect(Collectors.toList());
    }
    */
}
