package com.nklcb.cosmos.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class MemberDTO {

    @Getter
    @Builder
    @AllArgsConstructor
    @Schema(description = "사원추가 정보")
    public static class MemberInfo {

        @NotNull(message = "이메일은 필수 입력 값입니다.")
        private String email;
        @NotNull(message = "비밀번호는 필수 입력 값입니다.")
        private String password;
        @NotNull(message = "이름은 필수 입력 값입니다.")
        private String name;
        @NotNull(message = "전화번호는 필수 입력 값입니다.")
        private String phone;
        private String department;
        private String position;

    }

}
