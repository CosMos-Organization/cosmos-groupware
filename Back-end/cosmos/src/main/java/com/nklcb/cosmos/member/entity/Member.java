package com.nklcb.cosmos.member.entity;

import com.nklcb.cosmos.global.BaseEntity;

import jakarta.persistence.Entity;
import lombok.Builder;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseEntity {

    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String phone;
    @Column
    private String department;
    @Column
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
