package com.nklcb.cosmos.company.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class CompanyDTO {

    @Getter
    @AllArgsConstructor
    @Schema(name = "CompanyInfo", description = "회사 정보")
    public static class CompanyInfo {
        @NotNull
        @Schema(title = "회사명", example = "회사명")
        private String companyName;
        @NotNull
        @Schema(title = "담당자", example = "담당자")
        private String companyManagerEmail;
        // 비밀번호는 암호화 해야됨
        @NotNull
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
