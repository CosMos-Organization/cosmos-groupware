package com.nklcb.cosmos.member.entity;

import com.nklcb.cosmos.global.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String memberPk;

    @Column(length = 255, nullable = false)
    private String memberId;

    @Column(length = 255, nullable = false)
    private String memberPassword;

    @Column(length = 255, nullable = false)
    private String name;
}
