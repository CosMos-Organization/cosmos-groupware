package com.nklcb.cosmos.email.entity;

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
public class Email extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="memberId")
    private Member senderAddress; //보낸사람 이메일 주소

    @Column
    private String getterAddress; //받는 사람 이메일주소 => text로 복수의 사람을 넣을거라 $같은 구분자 end에 넣기

    @Column
    private String title;

    @Column
    private String content;

    @Builder
    public Email(Member senderAddress, String getterAddress, String content ){
        this.senderAddress = senderAddress;
        this.getterAddress = getterAddress;
        this.content = content;

    }

}
