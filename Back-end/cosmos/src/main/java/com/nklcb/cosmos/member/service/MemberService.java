package com.nklcb.cosmos.member.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nklcb.cosmos.member.dto.MemberDTO;
import com.nklcb.cosmos.member.entity.Member;
import com.nklcb.cosmos.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void createMember(MemberDTO.MemberInfo memberInfo) {

        // 비밀번호 암호화
        String encodedPwd = passwordEncoder.encode(memberInfo.getPassword());

        Member member = Member.builder()
                .email(memberInfo.getEmail())
                .password(encodedPwd)
                .name(memberInfo.getName())
                .phone(memberInfo.getPhone())
                .department(memberInfo.getDepartment())
                .position(memberInfo.getPosition())
                .build();

        memberRepository.save(member);
    }

    public List<Member> getMemberInfo() {
        return memberRepository.findAll();
    }
}