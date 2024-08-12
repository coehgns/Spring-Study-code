package com.example.springstudycode.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    // 400
    BAD_REQUEST(400, "잘못된 요청입니다."),

    // 404
    USER_NOT_FOUND(404, "해당 유저를 찾을 수 없습니다."),

    // 500
    INTERNAL_SERVER_ERROR(500, "Internal server error");

    private final int statusCode;
    private final String message;
}
