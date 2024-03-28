package com.nklcb.cosmos.jwt.entity;

import com.nklcb.cosmos.global.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class RefreshToken extends BaseEntity {

    private String email;
    private String refresh;
    private String expiration;

    @Builder

    public RefreshToken(String email, String refresh, String expiration) {
        this.email = email;
        this.refresh = refresh;
        this.expiration = expiration;
    }
}
