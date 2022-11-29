package com.example.hospitalreview2.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    DUPLICATED_USER_NAME(HttpStatus.CONFLICT, "userName 중복"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "userName 찾을 수 없음"),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST,"패스워드 틀림");


    private HttpStatus status;
    private String message;
}
