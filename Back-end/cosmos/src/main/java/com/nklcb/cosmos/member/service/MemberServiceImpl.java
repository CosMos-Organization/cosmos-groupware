package com.nklcb.cosmos.member.service;

import org.springframework.stereotype.Service;

import com.nklcb.cosmos.member.dto.MemberDTO;
import com.nklcb.cosmos.member.entity.Member;
import com.nklcb.cosmos.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public MemberDTO.MemberCreate createMember(MemberDTO.MemberCreate memberCreate) {

        Member member = new Member();

        member.builder()
                .email(memberCreate.getEmail())
                .password(memberCreate.getPassword())
                .name(memberCreate.getName())
                .phone(memberCreate.getPhone())
                .build();

        return memberRepository.save(member);

    }

}
