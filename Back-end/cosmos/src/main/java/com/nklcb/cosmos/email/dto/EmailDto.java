package com.nklcb.cosmos.email.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmailDto {

    @NotNull
    @Schema(description = "회원 ID(+@도메인주소)", example = "kjh@cosmos.com")
    private String senderAddress;

    @NotNull(message = "보낼 이메일 주소를 입력해주세요.")
    @Schema(description = "이메일", example = "kjh@cosmos.com;psh@cosmos.com")
    private String getterAddress;

    @NotBlank(message = "이메일 제목을 입력해주세요.")
//        @Size(message = "사용자 이름은 20글자 이하로 입력해야 합니다.")  정해지면 추가
    @Schema(description = "이메일 제목", example = "이메일 생성 제목")
    private String title;

    @Schema(description = "이메일 내용", example = "생성될 이메일 내용")
    private String content;



}
