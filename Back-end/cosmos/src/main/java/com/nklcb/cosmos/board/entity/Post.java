package com.nklcb.cosmos.board.entity;

import com.nklcb.cosmos.global.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {

    private String title;

    private String content;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

}
