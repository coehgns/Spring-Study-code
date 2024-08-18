package com.example.springstudycode.global.error;

import com.example.springstudycode.global.error.exception.ErrorCode;
import com.example.springstudycode.global.error.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j  // 선언된 클래스에 자동으로 로그 객체 생성.
@RestControllerAdvice  // 컨트롤러 전역에서 발생할 수 있는 예외를 잡아 Throw 해줌.
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class) // 특정 클래스에서 발생할 수 있는 예외를 잡아 Throw 해줌.
    protected ResponseEntity<ErrorResponse> handleUserException(UserException e) {

        ErrorCode errorCode = e.getErrorCode();
        ErrorResponse response = ErrorResponse.of(errorCode.getMessage(), errorCode.getStatusCode());

        // ResponseEntity는 HttpRequest에 대한 응답 데이터를 포함한 클래스임.
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(errorCode.getStatusCode()));
    }
}