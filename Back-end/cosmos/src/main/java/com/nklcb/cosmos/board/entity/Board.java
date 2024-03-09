package com.nklcb.cosmos.board.entity;

import com.nklcb.cosmos.global.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Board extends BaseEntity {
    private Long parentBoard;

    private String boardName;

    private Long boardOrder;

    private Long companyId; // 회사 테이블 생성되면 변경, 조인용

    @OneToMany(mappedBy = "board")
    List<Post> posts = new ArrayList<>();

    @Builder
    public Board(Long parentBoard, String boardName, Long boardOrder, Long companyId) {
        this.boardName = boardName;
        this.boardOrder = boardOrder;
        this.companyId = companyId;
        this.parentBoard = parentBoard;
    }
}
