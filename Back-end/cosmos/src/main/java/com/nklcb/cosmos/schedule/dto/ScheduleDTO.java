package com.nklcb.cosmos.schedule.dto;

import com.nklcb.cosmos.schedule.entity.Schedule;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScheduleDTO {
    @Getter
    @AllArgsConstructor
    @Schema(description = "일정 생성 요청")
    public static class ScheduleCreateRequest{

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
        @Schema(description = "일정 시작날짜", example = "")
        private String schStart;

        @NotNull(message = "일정 종료날짜를 입력해주세요.")
        @Schema(description = "일정 종료날짜", example = "")
        private String schEnd;

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
    public static class ScheduleResponse{

        @Schema(description = "일정 ID", example = "1L")
        private final Long scheduleId;
        public static ScheduleResponse of(Schedule schedule){
            return ScheduleResponse.builder()
                    .scheduleId(schedule.getId())
                    .build();
        }
    }
}
