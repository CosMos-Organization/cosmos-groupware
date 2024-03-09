package com.nklcb.cosmos.board.controller;

import com.nklcb.cosmos.board.dto.BoardDto;

import com.nklcb.cosmos.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<?> initBoard(@RequestBody BoardDto.BoardRequest boardRequest) {
        boardService.initBoard(boardRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("board init 성공");
    }

    @GetMapping
    public ResponseEntity<List<BoardDto.BoardResponse>> selectBoards(@RequestParam Long companyId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(boardService.selectBoards(companyId));
    }

    @PutMapping
    public ResponseEntity<?> updateBoard(@RequestBody BoardDto.BoardUpdateRequest boardUpdateRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body("board init 성공");
    }
}
