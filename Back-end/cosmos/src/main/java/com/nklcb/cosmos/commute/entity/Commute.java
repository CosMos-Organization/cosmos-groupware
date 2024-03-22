package com.nklcb.cosmos.commute.entity;

import java.time.LocalDateTime;

import com.nklcb.cosmos.global.BaseEntity;
import com.nklcb.cosmos.member.entity.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Commute extends BaseEntity {
    
    @Column
    private LocalDateTime commuteStart;

    @Column
    private LocalDateTime commuteEnd;

    @Column
    private String commuteType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "member_id")
    private Member member;
    
    @Builder
    public Commute(LocalDateTime commuteStart, LocalDateTime commuteEnd, String commuteType, Member member){
        this.commuteStart = commuteStart;
        this.commuteEnd = commuteEnd;
        this.commuteType = commuteType;
        this.member = member;
    }
}
