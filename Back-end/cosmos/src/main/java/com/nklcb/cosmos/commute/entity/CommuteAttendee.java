package com.nklcb.cosmos.commute.entity;

import com.nklcb.cosmos.global.BaseEntity;
import com.nklcb.cosmos.member.entity.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class CommuteAttendee extends BaseEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(optional = false)
    @JoinColumn(name = "commute_id") // 테이블 수정 필요
    private Commute commute;

    @Builder
    public CommuteAttendee(Member member, Commute commute) {
        this.member = member;
        this.commute = commute;
    }
}
