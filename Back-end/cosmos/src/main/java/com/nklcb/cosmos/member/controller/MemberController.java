package com.nklcb.cosmos.member.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nklcb.cosmos.member.dto.MemberDTO;
import com.nklcb.cosmos.member.entity.Member;
import com.nklcb.cosmos.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/insert")
    public String createMember(@RequestBody MemberDTO.MemberInfo memberInfo) {
        memberService.createMember(memberInfo);
        return "hello";
    }

    @GetMapping("/list")
    public List<Member> getMemberList() {
        List<Member> memberList = memberService.getMemberInfo();
        return memberList;
    }

}
