package com.nklcb.cosmos.board.dto;

import com.nklcb.cosmos.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class BoardDto {

    @Getter
    public static class BoardRequest {
        private Long companyId;
    }

    @Getter
    public static class BoardUpdateRequest{
        private Long companyId;
        private List<BoardData> boardDataList;
    }

    @Getter
    public static class BoardData{
        private Long boardId;
        private Long parentBoard;
        private Long boardOrder;
        private String boardName;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class BoardResponse {
        private Long companyId;
        private Long boardId;
        private Long parentBoard;
        private String boardName;
        private Long boardOrder;
        private List<BoardResponse> childBoard;

        public static BoardResponse of(Board board){
            return BoardResponse.builder()
                    .companyId(board.getCompanyId())
                    .boardId(board.getId())
                    .boardName(board.getBoardName())
                    .parentBoard(board.getParentBoard())
                    .boardOrder(board.getBoardOrder())
                    .childBoard(new ArrayList<>())
                    .build();
        }
    }
}
