package com.nklcb.cosmos.commute.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.nklcb.cosmos.commute.entity.Commute;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class CommuteDTO {

    @Getter
    @AllArgsConstructor
    @Schema(description = "출퇴근 기록 요청")
    public static class CommuteCreateRequest {

        @NotNull(message = "회원 ID를 입력해주세요")
        @Schema(description = "회원 ID", example = "1L")
        private Long memberId;

        @Schema(description = "근태 타입", example = "출근")
        private String commuteType;

        @NotNull(message = "시작시간를 입력해주세요.")
        @Schema(description = "회원 ID", example = "1L")
        private String commuteStart;

        @NotNull(message = "종료시간를 입력해주세요.")
        @Schema(description = "회원 ID", example = "1L")
        private String commuteEnd;

        public LocalDateTime getCommuteStart() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            return LocalDateTime.parse(this.commuteStart, formatter);
        }

        public LocalDateTime getCommuteEnd() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            return LocalDateTime.parse(this.commuteEnd, formatter);
        }
    }
    // 근태 종류 구분할 방법 추후 추가할 것

    @Getter
    @Builder
    @AllArgsConstructor
    @Schema(description = "출퇴근 응답")
    public static class CommuteResponse {

        @Schema(description = "출퇴근 ID", example = "1L")
        private final Long commuteId;

        public static CommuteResponse of(Commute commute) {
            return CommuteResponse.builder()
                    .commuteId(commute.getId())
                    .build();

        }
    }
}
