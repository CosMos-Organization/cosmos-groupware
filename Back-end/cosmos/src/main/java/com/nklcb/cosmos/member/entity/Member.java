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
public class Member extends BaseEntity implements UserDetails {


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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
