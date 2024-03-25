package com.nklcb.cosmos.company.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class CompanyDTO {

    @Getter
    @AllArgsConstructor
    @Schema(name = "CompanyInfo", description = "회사 정보")
    public static class CompanyInfo {
        @NotBlank(message = "회사명은 필수 입력 값입니다.")
        @Schema(title = "회사명", example = "회사명")
        private String companyName;
        @NotBlank(message = "담당자는 필수 입력 값입니다.")
        @Schema(title = "담당자", example = "담당자")
        private String companyManagerEmail;
        // 비밀번호는 암호화 해야됨
        @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
        @Schema(title = "비밀번호", example = "비밀번호")
        private String companyPassword;
        // 직원수는 카운팅으로 해야될듯
        // @Schema(title = "직원수", example = "직원수")
        // private int employeeCount;
        @Schema(title = "회사 전화번호", example = "회사 전화번호")
        private int companyPhone;
        @Schema(title = "회사 생성일", example = "회사 생성일")
        private LocalDateTime companyCreatedAt;
    }

}
