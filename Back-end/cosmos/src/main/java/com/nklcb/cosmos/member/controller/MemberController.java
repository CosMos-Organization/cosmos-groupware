package com.nklcb.cosmos.member.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nklcb.cosmos.member.dto.MemberDTO;
import com.nklcb.cosmos.member.service.MemberService;

@RestController
@CrossOrigin("*")
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/")
    public String requestMethodName(@RequestBody MemberDTO.MemberCreate memberCreate) {
        System.out.println("진입함?");
        System.out.println(memberCreate.getMemberid());
        System.out.println(memberCreate.getName());
        System.out.println(memberCreate.getDepartment());
        System.out.println(memberCreate.getPosition());
        System.out.println(memberCreate.getPhone());
        System.out.println(memberCreate.getEmail());

        memberService.createMember(memberCreate);

        return "hello";
    }

}
