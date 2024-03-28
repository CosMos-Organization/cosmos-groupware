package com.nklcb.cosmos.schedule.dto;

import com.nklcb.cosmos.member.dto.MemberDTO;
import com.nklcb.cosmos.schedule.entity.Schedule;
import com.nklcb.cosmos.schedule.entity.ScheduleAttendee;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class ScheduleDTO {
    @Getter
    @AllArgsConstructor
    @Schema(description = "일정 생성 요청")
    public static class ScheduleCreateRequest {

        @NotNull(message = "회원 ID를 입력해주세요.")
        @Schema(description = "회원 ID", example = "1L")
        private Long memberId;

        @NotBlank(message = "일정 제목을 입력해주세요.")
        @Schema(description = "일정 제목", example = "일정 생성 제목")
        private String schTitle;

        @Schema(description = "일정 장소", example = "생성될 일정 내용")
        private String schPlace;

        @Schema(description = "일정 내용", example = "생성될 일정 내용")
        private String schContent;

        @NotNull(message = "일정 시작날짜를 입력해주세요.")
        @Schema(description = "일정 시작날짜", example = "yyyy-MM-dd HH:mm", type = "string")
        private String schStart;

        @NotNull(message = "일정 종료날짜를 입력해주세요.")
        @Schema(description = "일정 종료날짜", example = "yyyy-MM-dd HH:mm", type = "string")
        private String schEnd;

        @NotNull(message = "참석자 ID를 입력해주세요.")
        @Schema(description = "참석자 ID 목록", example = "[2L, 3L]")
        private List<Long> attendeeIds;

        public LocalDateTime getSchStart() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            return LocalDateTime.parse(this.schStart, formatter);
        }

        public LocalDateTime getSchEnd() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            return LocalDateTime.parse(this.schEnd, formatter);
        }

        // 일정 참가자들 컬럼 추가해야 됨
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @Schema(description = "일정 생성 응답")
    public static class ScheduleResponse {

        @Schema(description = "일정 ID", example = "1L")
        private final Long scheduleId;

        public static ScheduleResponse of(Schedule schedule) {
            return ScheduleResponse.builder()
                    .scheduleId(schedule.getId())
                    .build();
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @Schema(description = "전체 일정 조회 응답")
    public static class AllSchedulesResponse {

        @Schema(description = "일정 목록")
        private final Long scheduleId;
        private final Long memberId;
        private final String schTitle;
        private final String schPlace;
        private final String schContent;
        private final String schStart;
        private final String schEnd;
        private final List<MemberDTO.MemberInfo> attendees;

        public static List<AllSchedulesResponse> getAllSchedulesResponses(List<Schedule> schedules) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            return schedules.stream()
                    .map(schedule -> AllSchedulesResponse.builder()
                            .scheduleId(schedule.getId())
                            .memberId(schedule.getMember().getId())
                            .schTitle(schedule.getSchTitle())
                            .schPlace(schedule.getSchPlace())
                            .schContent(schedule.getSchContent())
                            .schStart(schedule.getSchStart().format(formatter))
                            .schEnd(schedule.getSchEnd().format(formatter))
                            .attendees(schedule.getScheduleAttendeeList().stream()
                                    .map(attendee -> MemberDTO.MemberInfo.builder()
                                            .email(attendee.getMember().getEmail())
                                            .name(attendee.getMember().getName())
                                            .build())
                                    .collect(Collectors.toList()))
                            .build())
                    .collect(Collectors.toList());
        }

    }
}
