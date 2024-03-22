package com.nklcb.cosmos.commute.service;

import org.springframework.stereotype.Service;

import com.nklcb.cosmos.commute.dto.CommuteDTO;
import com.nklcb.cosmos.commute.entity.Commute;
import com.nklcb.cosmos.commute.repository.CommuteAttendeeRepositoty;
import com.nklcb.cosmos.commute.repository.CommuteRepositoty;
import com.nklcb.cosmos.member.entity.Member;
import com.nklcb.cosmos.member.repository.MemberRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommuteServiceImpl implements CommuteService {

    private final CommuteRepositoty commuteRepositoty;
    private final CommuteAttendeeRepositoty commuteAttendeeRepositoty;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public CommuteDTO.CommuteResponse createCommute(CommuteDTO.CommuteCreateRequest commuteCreateRequest) {

        Member member = memberRepository.findById(commuteCreateRequest.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다."));
        
        Commute commute = Commute.builder()
                .commuteType(commuteCreateRequest.getCommuteType())
                .commuteStart(commuteCreateRequest.getCommuteStart())
                .commuteEnd(commuteCreateRequest.getCommuteEnd())
                .member(member)
                .build();

        Commute saveCommute = commuteRepositoty.save(commute);

        return CommuteDTO.CommuteResponse.of(saveCommute);
    }
}
