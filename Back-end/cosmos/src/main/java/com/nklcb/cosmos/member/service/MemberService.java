package com.nklcb.cosmos.member.service;

import com.nklcb.cosmos.member.dto.MemberDTO;

public interface MemberService {

    public MemberDTO.MemberCreate createMember(MemberDTO.MemberCreate memberCreate);
}