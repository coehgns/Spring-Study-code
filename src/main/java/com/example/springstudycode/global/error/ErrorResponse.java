package com.example.springstudycode.global.error;

import lombok.*;


@Getter
@Builder
@AllArgsConstructor
public class ErrorResponse {

    private int status;
    private String message;

    public static ErrorResponse of(String message, int status) {
        return  ErrorResponse.builder()
                .message(message)
                .status(status)
                .build();
    }
}
