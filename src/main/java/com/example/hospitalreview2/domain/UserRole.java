package com.example.hospitalreview2.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {

    NORMAL("normal"),ADMIN("Admin");
    private String role;
}
