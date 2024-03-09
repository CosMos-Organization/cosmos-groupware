package com.nklcb.cosmos.board.entity;

import com.nklcb.cosmos.global.BaseEntity;
import com.nklcb.cosmos.member.entity.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Post extends BaseEntity {

    private String title;

    private String content;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Post(String title, String content, Board board, Member member) {
        this.title = title;
        this.content = content;
        this.board = board;
        this.member = member;
    }


}
