package com.example.hospitalreview2.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String userName;
    private String password;
    private String emailAddress;
}
