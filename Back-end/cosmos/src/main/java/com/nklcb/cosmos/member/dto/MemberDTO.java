package com.nklcb.cosmos.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class MemberDTO {

    @Getter
    @AllArgsConstructor
    @Schema(description = "사원추가 정보")
    public static class MemberInfo {

        @NotBlank(message = "이메일은 필수 입력 값입니다.")
        private String email;

        private String password;
        private String name;
        private String phone;
        private String department;
        private String position;

    }

}
