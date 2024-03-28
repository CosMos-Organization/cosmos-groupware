package com.nklcb.cosmos.schedule.service;


import com.nklcb.cosmos.member.entity.Member;
import com.nklcb.cosmos.member.repository.MemberRepository;
import com.nklcb.cosmos.schedule.dto.ScheduleDTO;
import com.nklcb.cosmos.schedule.entity.Schedule;
import com.nklcb.cosmos.schedule.entity.ScheduleAttendee;
import com.nklcb.cosmos.schedule.repository.ScheduleAttendeeRepository;
import com.nklcb.cosmos.schedule.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleAttendeeRepository scheduleAttendeeRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public ScheduleDTO.ScheduleResponse createSchedule(ScheduleDTO.ScheduleCreateRequest scheduleCreateRequest) {

        // 작성자
        Member member = memberRepository.findById(scheduleCreateRequest.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다."));

        // 일정 등록
        Schedule schedule = Schedule.builder()
                .schTitle(scheduleCreateRequest.getSchTitle())
                .schStart(scheduleCreateRequest.getSchStart())
                .schEnd(scheduleCreateRequest.getSchEnd())
                .schPlace(scheduleCreateRequest.getSchPlace())
                .schContent(scheduleCreateRequest.getSchContent())
                .member(member)
                .build();

        Schedule saveSchedule = scheduleRepository.save(schedule);

        // 참석자 등록
        List<ScheduleAttendee> attendees = scheduleCreateRequest.getAttendeeIds().stream()
                .map(attendeeId -> {
                    Member attendee = memberRepository.findById(attendeeId)
                            .orElseThrow(() -> new IllegalArgumentException("참석자를 찾을 수 없습니다."));
                    return new ScheduleAttendee(attendee, saveSchedule);
                })
                .collect(Collectors.toList());

        scheduleAttendeeRepository.saveAll(attendees);

        return ScheduleDTO.ScheduleResponse.of(saveSchedule);
    }

    public void deleteSchedule(Long scheduleId) {
        // 일정 참석자 삭제
        List<ScheduleAttendee> attendees = scheduleAttendeeRepository.findByScheduleId(scheduleId);
        scheduleAttendeeRepository.deleteAll(attendees);

        // 일정 삭제
        scheduleRepository.deleteById(scheduleId);

    }

    public List<ScheduleDTO.AllSchedulesResponse> getAllSchedules() {
        List<Schedule> allSchedules = scheduleRepository.findAll();
        return ScheduleDTO.AllSchedulesResponse.getAllSchedulesResponses(allSchedules);
    }
}
