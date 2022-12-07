package com.example.hospitalreview2.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VisitListResponse {
    private String userName;
    private String hospitalName;
    private String diseaseName;
    private LocalDate localDate;
    private Float amount;
}
