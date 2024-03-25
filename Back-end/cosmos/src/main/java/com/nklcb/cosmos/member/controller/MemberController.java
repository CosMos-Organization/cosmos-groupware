package com.nklcb.cosmos.member.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nklcb.cosmos.member.dto.MemberDTO;
import com.nklcb.cosmos.member.entity.Member;
import com.nklcb.cosmos.member.service.MemberService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin_company")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/insert")
    @Operation(summary = "signin", description = "회원가입")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "회원가입 성공"),
            @ApiResponse(responseCode = "400", description = "회원가입 실패")
    })
    public ResponseEntity<Void> createMember(@Valid @RequestBody MemberDTO.MemberInfo memberInfo) {
        memberService.createMember(memberInfo);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    @Operation(summary = "findMember", description = "사원 리스트 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "사원 리스트 조회 성공"),
            @ApiResponse(responseCode = "400", description = "사원 리스트 조회 실패")
    })
    public List<Member> getMemberList() {
        List<Member> memberList = memberService.getMemberInfo();
        return memberList;
    }

}
