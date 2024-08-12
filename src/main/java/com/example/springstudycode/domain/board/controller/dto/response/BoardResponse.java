package com.example.springstudycode.domain.board.controller.dto.response;


import com.example.springstudycode.domain.board.entity.Board;
import lombok.Builder;

@Builder
public class BoardResponse {
    private String title;
    private String content;

    public static BoardResponse boardResponse(Board board) {
        return BoardResponse.builder()
                .content(board.getContent())
                .title(board.getTitle())
                .build();
    }
}
