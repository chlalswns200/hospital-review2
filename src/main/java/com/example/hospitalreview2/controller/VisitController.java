package com.example.hospitalreview2.controller;

import com.example.hospitalreview2.domain.dto.VisitCreateRequest;
import com.example.hospitalreview2.service.VisitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/visit")
@RequiredArgsConstructor
@Slf4j
public class VisitController {

    private final VisitService visitService;


    @PostMapping("")
    public ResponseEntity<String> createVisitLog(@RequestBody VisitCreateRequest visitCreateRequest, Authentication authentication) {
        String userName = authentication.getName();
        log.info("{}",visitCreateRequest.getHospitalId());
        log.info("{}",visitCreateRequest.getDiseaseName());
        log.info("{}",visitCreateRequest.getAmount());
        visitService.createVisit(visitCreateRequest,userName);
        return ResponseEntity.ok("등록 완료");

    }
}
