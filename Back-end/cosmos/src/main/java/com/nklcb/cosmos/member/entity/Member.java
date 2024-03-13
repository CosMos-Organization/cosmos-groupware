package com.nklcb.cosmos.member.entity;

import com.nklcb.cosmos.global.BaseEntity;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseEntity {

    private String memberid;
    private String name;
    private String department;
    private String position;
    private String phone;
    private String email;

    @Builder
    public Member(String memberid, String name, String department, String position, String phone, String email) {
        this.memberid = memberid;
        this.name = name;
        this.department = department;
        this.position = position;
        this.phone = phone;
        this.email = email;
    }

}