package com.nklcb.cosmos.board.service;


import com.nklcb.cosmos.board.dto.BoardDto;
import com.nklcb.cosmos.board.entity.Board;
import com.nklcb.cosmos.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    @Override
    @Transactional
    public void initBoard(BoardDto.BoardRequest boardInitRequest) {
        ///회사 조회 후 없으면 예외 발생

        ///
        Board board = Board.builder()
                .boardName("공지사항")
                .companyId(boardInitRequest.getCompanyId())
                .boardOrder(0L)
                .parentBoard(0L)
                .build();
        boardRepository.save(board);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BoardDto.BoardResponse> selectBoards(Long companyId) {
        List<Board> boards = boardRepository.findByCompanyIdOrderByBoardOrder(companyId);
        if(boards.isEmpty()){
            throw new IllegalStateException("회사 ID가 잘못되었습니다.");
        }
        return makeResponseList(boards);
    }



    @Override
    @Transactional
    public List<BoardDto.BoardResponse> updateBoard(BoardDto.BoardUpdateRequest boardUpdateRequest) {

        //이전 게시판 구조
        List<Board> beforeBoardList = boardRepository.findByCompanyIdOrderByBoardOrder(boardUpdateRequest.getCompanyId());
        if(beforeBoardList.isEmpty()){
            throw new IllegalStateException("회사 ID가 잘못되었습니다.");
        }

        //새 게시판 구조
        List<BoardDto.BoardData> boardDataList = boardUpdateRequest.getBoardDataList();


        List<Board> createBoardList = new ArrayList<>();   // 크기만큼 설정
        List<Board> deleteBoardList = new ArrayList<>();



        boolean [] isDeleted = new boolean[beforeBoardList.size()];


        for (BoardDto.BoardData curData : boardDataList) {

            if(curData.getBoardId() == null){ // id가 null -> 새로 생성하는 테이블
                Board newBoard = Board.builder()
                        .parentBoard(curData.getParentBoard())
                        .boardOrder(curData.getBoardOrder())
                        .boardName(curData.getBoardName())
                        .companyId(boardUpdateRequest.getCompanyId())
                        .build();
                createBoardList.add(newBoard);
                continue;
            }

            for (int i = 0; i < beforeBoardList.size(); i++) { // 원래 게시판을 돌면서 요청 게시판이 있는지 탐색
                if(!isDeleted[i] && Objects.equals(beforeBoardList.get(i).getId(), curData.getBoardId())){// 게시판이 있을 경우 내용 수정
                    isDeleted[i] = true;
                    Board updateBoard = beforeBoardList.get(i);
                    updateBoard.setBoardName(curData.getBoardName());
                    updateBoard.setBoardOrder(curData.getBoardOrder());
                    updateBoard.setParentBoard(curData.getParentBoard());
                    break;
                }
            }
        }

        for (int i = 0; i < beforeBoardList.size(); i++) { // 원래 게시판에는 있었지만 요청에는 없는 ID -> 삭제되는 게시판
            if (!isDeleted[i]){
                deleteBoardList.add(beforeBoardList.get(i));
            }
        }

        boardRepository.saveAll(createBoardList);
        boardRepository.deleteAll(deleteBoardList);


        return makeResponseList(boardRepository.findByCompanyIdOrderByBoardOrder(boardUpdateRequest.getCompanyId()));
    }

    /*
    *  자식노드와 부모노드를 연결해주는 응답 생성
    * */
    private List<BoardDto.BoardResponse> makeResponseList(List<Board> boards) {
        List<BoardDto.BoardResponse> responseList = new ArrayList<>();
        Map<Long, Integer> seq = new HashMap<>();
        for (Board curBoard : boards) {
            if (curBoard.getParentBoard() == 0) {
                seq.put(curBoard.getId(), responseList.size());
                responseList.add(BoardDto.BoardResponse.of(curBoard));
            } else {
                int parentBoardSeq = seq.get(curBoard.getParentBoard());
                responseList.get(parentBoardSeq).getChildBoard().add(BoardDto.BoardResponse.of(curBoard));
            }
        }
        return responseList;
    }
}
