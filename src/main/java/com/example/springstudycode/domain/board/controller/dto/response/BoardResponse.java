package com.example.springstudycode.domain.board.controller.dto.response;


import lombok.Builder;

@Builder
public class BoardResponse {
    private String title;
    private String content;
}
