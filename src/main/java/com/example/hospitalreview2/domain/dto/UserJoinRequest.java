package com.example.hospitalreview2.domain.dto;

import com.example.hospitalreview2.domain.User;
import com.example.hospitalreview2.domain.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserJoinRequest {

    private String userName;
    private String password;
    private String emailAddress;
    private UserRole role;
    public User toEntity(String password) {
        return User.builder()
                .userName(this.userName)
                .password(password)
                .emailAddress(this.emailAddress)
                .role(this.role)
                .build();
    }
}

