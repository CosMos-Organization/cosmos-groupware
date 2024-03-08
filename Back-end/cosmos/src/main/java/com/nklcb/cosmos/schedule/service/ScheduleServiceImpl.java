package com.nklcb.cosmos.schedule.service;

import com.nklcb.cosmos.member.entity.Member;
import com.nklcb.cosmos.schedule.dto.ScheduleDTO;
import com.nklcb.cosmos.schedule.entity.Schedule;
import com.nklcb.cosmos.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepository scheduleRepository;

    @Override
    public ScheduleDTO.ScheduleResponse createSchedule(ScheduleDTO.ScheduleCreateRequest scheduleCreateRequest) {

        // 작성자
        Member member = new Member();
        member.setId(1L);

        Schedule schedule = Schedule.builder()
                .schTitle(scheduleCreateRequest.getSchTitle())
                .schStart(scheduleCreateRequest.getSchStart())
                .schEnd(scheduleCreateRequest.getSchEnd())
                .schPlace(scheduleCreateRequest.getSchPlace())
                .schContent(scheduleCreateRequest.getSchContent())
                .member(member)
                .build();

        return ScheduleDTO.ScheduleResponse.of(scheduleRepository.save(schedule));
    }




}
