package com.example.hospitalreview2.domain.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReviewAddRequest {
    private String title;
    private  String content;
    private String userName;
}