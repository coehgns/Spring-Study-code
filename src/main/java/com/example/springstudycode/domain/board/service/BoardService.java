package com.example.springstudycode.domain.board.service;

import com.example.springstudycode.domain.board.controller.dto.request.BoardCreateRequest;
import com.example.springstudycode.domain.board.controller.dto.request.BoardUpdateRequest;
import com.example.springstudycode.domain.board.controller.dto.response.BoardResponse;
import com.example.springstudycode.domain.board.entity.Board;
import com.example.springstudycode.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private BoardRepository boardRepository;

    public List<BoardResponse> findAllBoard() {
        return boardRepository.findAll()
                .stream()
                .map(BoardResponse::boardResponse)
                .toList();
    }

    public void addBoard(BoardCreateRequest request) {

        boardRepository.save(
                Board.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .build()
        );
    }

    public BoardResponse onlyFindBoard(Long bordId) {
        Board board = boardRepository.findById(bordId)
                .orElseThrow(() -> new RuntimeException("not found"));

        return BoardResponse.builder()
                .title(board.getTitle())
                .content(board.getContent())
                .build();
    }

    @Transactional
    public void modifyBoard(Long boardId, BoardUpdateRequest request) {

        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("not found."));

        board.updateBoard(request.getTitle(), request.getContent());

    }

    public void deleteBoard(Long boardId) {

        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("not found."));

        boardRepository.delete(board);
    }

}