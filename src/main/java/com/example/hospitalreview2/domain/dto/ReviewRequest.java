package com.example.hospitalreview2.domain.dto;
import lombok.Getter;
@Getter
public class ReviewRequest {
    private Long hospitalId;
    private String content;
    private String userName;
}