package com.nklcb.cosmos.member.service;

import org.springframework.stereotype.Service;

import com.nklcb.cosmos.member.dto.MemberDTO;
import com.nklcb.cosmos.member.entity.Member;
import com.nklcb.cosmos.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void createMember(MemberDTO.MemberCreate memberCreate) {
        Member member = Member.builder()
                .memberid(memberCreate.getMemberid())
                .name(memberCreate.getName())
                .department(memberCreate.getDepartment())
                .position(memberCreate.getPosition())
                .phone(memberCreate.getPhone())
                .email(memberCreate.getEmail())
                .build();

        memberRepository.save(member);
    }
}