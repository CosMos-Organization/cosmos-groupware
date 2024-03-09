package com.nklcb.cosmos.board.service;


import com.nklcb.cosmos.board.dto.BoardDto;
import com.nklcb.cosmos.board.entity.Board;
import com.nklcb.cosmos.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public void initBoard(BoardDto.BoardRequest boardInitRequest) {
        ///회사 조회 후 없으면 예외 발생

        ///
        Board board = Board.builder()
                .boardName("공지사항")
                .companyId(boardInitRequest.getCompanyId())
                .boardOrder(1L)
                .parentBoard(0L)
                .build();
        boardRepository.save(board);
    }


    @Transactional(readOnly = true)
    public List<BoardDto.BoardResponse> selectBoards(Long companyId) {
        List<Board> boards = boardRepository.findByCompanyIdOrderByBoardOrder(companyId);
        if(boards.size() == 0){
            throw new IllegalStateException("회사 ID가 잘못되었습니다.");
        }
        return boards.stream().map(BoardDto.BoardResponse::of).collect(Collectors.toList());
    }
}
