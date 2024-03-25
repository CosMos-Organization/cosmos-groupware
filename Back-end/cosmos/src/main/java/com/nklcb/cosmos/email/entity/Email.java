package com.nklcb.cosmos.email.entity;

import com.nklcb.cosmos.global.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Email extends BaseEntity {

//    @ManyToOne
//    @JoinColumn(name="senderAddress")
//    private Member senderAddress; //보낸사람 이메일 주소
    @Column
    private String senderAddress; //보낸사람 이메일 주소

    @Column
    private String getterAddress; //받는 사람 이메일주소 => text로 복수의 사람을 넣을거라 $같은 구분자 end에 넣기

    @Column
    private String title;

    @Column
    private String content;

    @Builder
    public Email(String senderAddress, String getterAddress,String title ,String content ){
        this.senderAddress = senderAddress;
        this.title = title;
        this.getterAddress = getterAddress;
        this.content = content;

    }

}
