package com.example.hospitalreview2.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserJoinRequest {

    private String userName;
    private String password;
    private String email;
}

