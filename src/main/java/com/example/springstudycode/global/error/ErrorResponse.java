package com.example.springstudycode.global.error;

import com.example.springstudycode.global.error.exception.ErrorCode;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ErrorResponse {

    private LocalDateTime timestamp = LocalDateTime.now();
    private int status;
    private String message;

    public static ErrorResponse of(ErrorCode errorCode) {
        return  ErrorResponse.builder()
                .message(errorCode.getMessage())
                .status(errorCode.getStatusCode())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
