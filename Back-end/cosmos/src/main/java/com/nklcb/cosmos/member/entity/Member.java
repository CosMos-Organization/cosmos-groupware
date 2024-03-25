package com.nklcb.cosmos.member.entity;

import com.nklcb.cosmos.global.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseEntity {

    private String email;
    private String password;
    private String name;
    private String phone;
    private String department;
    private String position;

    @Builder
    public Member(String email, String password, String name, String phone, String department, String position) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.department = department;
        this.position = position;
    }

}