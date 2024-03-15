package com.nklcb.cosmos.schedule.entity;

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
public class ScheduleAttendee extends BaseEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "member_id")
    private Member member;      // 참석자

    @ManyToOne(optional = false)
    @JoinColumn(name = "sch_id")
    private Schedule schedule;      // 일정

    @Builder
    public ScheduleAttendee(Member member, Schedule schedule) {
        this.member = member;
        this.schedule = schedule;
    }
}
