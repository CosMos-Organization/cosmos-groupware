package com.nklcb.cosmos.email.service;

import com.nklcb.cosmos.email.dto.EmailDto;
import com.nklcb.cosmos.email.entity.Email;
import com.nklcb.cosmos.email.repository.EmailRepository;
import com.nklcb.cosmos.member.entity.Member;
import com.nklcb.cosmos.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import nonapi.io.github.classgraph.json.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmailService {


    private final EmailRepository emailRepository;
    private final MemberRepository memberRepository;


    public void writeEmail(EmailDto emailDto) {

        Optional<Member> member = memberRepository.findByMemberId(emailDto.getSenderAddress());

        Email email = Email.builder()
                .senderAddress(member.get())
                .getterAddress(emailDto.getGetterAddress())
                .content(emailDto.getContent())
                .build();
        emailRepository.save(email);


    }
}