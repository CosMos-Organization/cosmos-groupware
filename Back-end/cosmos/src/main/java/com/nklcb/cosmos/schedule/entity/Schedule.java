package com.nklcb.cosmos.schedule.entity;

import com.nklcb.cosmos.global.BaseEntity;
import com.nklcb.cosmos.member.entity.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@Entity
public class Schedule extends BaseEntity {

    @Column
    private LocalDateTime schStart;     // 일정 시작일

    @Column
    private LocalDateTime schEnd;       // 일정 종료일

    @Column(length = 255, nullable = false)
    private String schTitle;        // 일정 제목

    @Column(length = 255, nullable = false)
    private String schPlace;        // 일정 장소

    @Column(length = 255, nullable = false)
    private String schContent;      // 일정 내용

    @ManyToOne(optional = false)
    @JoinColumn(name = "member_id")
    private Member member;      // 작성자


    @Builder
    public Schedule(LocalDateTime schStart, LocalDateTime schEnd, String schTitle, String schPlace, String schContent, Member member) {
        this.schStart = schStart;
        this.schEnd = schEnd;
        this.schTitle = schTitle;
        this.schPlace = schPlace;
        this.schContent = schContent;
        this.member = member;
    }
}
