package com.nklcb.cosmos.board.service;

import com.nklcb.cosmos.board.dto.BoardDto;

import java.util.List;

public interface BoardService {
    void initBoard(BoardDto.BoardRequest boardInitRequest);
    public List<BoardDto.BoardResponse> selectBoards(Long companyId);
}
