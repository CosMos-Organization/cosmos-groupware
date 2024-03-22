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

    private String memberId;
    private String refresh;
    private String expiration;

    @Builder

    public RefreshToken(String memberId, String refresh, String expiration) {
        this.memberId = memberId;
        this.refresh = refresh;
        this.expiration = expiration;
    }
}
