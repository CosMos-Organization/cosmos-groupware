package com.nklcb.cosmos.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nklcb.cosmos.member.dto.MemberDTO;
import com.nklcb.cosmos.member.entity.Member;
import com.nklcb.cosmos.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void createMember(MemberDTO.MemberInfo memberInfo) {
        Member member = Member.builder()
                .memberId(memberInfo.getMemberId())
                .password(memberInfo.getPassword())
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