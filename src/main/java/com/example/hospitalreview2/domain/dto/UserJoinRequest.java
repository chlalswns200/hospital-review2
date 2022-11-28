package com.example.hospitalreview2.domain.dto;

import com.example.hospitalreview2.domain.User;
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

    public User toEntity() {
        return User.builder()
                .userName(this.userName)
                .password(this.password)
                .emailAddress(this.emailAddress)
                .build();
    }
}

