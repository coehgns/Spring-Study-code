package com.example.springstudycode.domain.board.controller;

import com.example.springstudycode.domain.board.controller.dto.request.BoardCreateRequest;
import com.example.springstudycode.domain.board.controller.dto.request.BoardUpdateRequest;
import com.example.springstudycode.domain.board.controller.dto.response.BoardResponse;
import com.example.springstudycode.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spring-study/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public void boardAdd(@RequestBody BoardCreateRequest request) {
        boardService.addBoard(request);
    }

    @GetMapping
    public List<BoardResponse> boardAllList() {
        return boardService.findAllBoard();
    }

    @GetMapping("/{boardId}")
    public BoardResponse boardDetails(@PathVariable Long boardId) {
        return boardService.onlyFindBoard(boardId);
    }

    @PutMapping("/{boardId}")
    public void boardModify(@RequestBody Long boardId, BoardUpdateRequest request) {
        boardService.modifyBoard(boardId, request);
    }

    @DeleteMapping("/{boardId}")
    public void boardRemove(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);
    }

}
