package com.nklcb.cosmos.board.dto;

import com.nklcb.cosmos.board.entity.Post;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PostDto {
    @Getter
    @AllArgsConstructor
    @Schema(description = "게시글 생성 요청")
    public static class PostCreateRequest{

        @NotNull(message = "게시판ID를 입력해주세요.")
        @Schema(description = "게시판 ID", example = "1L")
        private Long boardId;

        @NotNull(message = "회원 ID를 입력해주세요.")
        @Schema(description = "회원 ID", example = "1L")
        private Long memberId;

        @NotBlank(message = "게시글 제목을 입력해주세요.")
//        @Size(message = "사용자 이름은 20글자 이하로 입력해야 합니다.")  정해지면 추가
        @Schema(description = "게시글 제목", example = "게시글 생성 제목")
        private String title;

//        @Size(message = "사용자 이름은 20글자 이하로 입력해야 합니다.")  정해지면 추가
        @Schema(description = "게시글 내용", example = "생성될 게시글 내용")
        private String content;

        /*
        *   첨부 파일 변수 이후 추가.
        *
        * */
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @Schema(description = "게시글 생성 응답")
    public static class PostResponse{

        @Schema(description = "게시글 ID", example = "1L")
        private final Long postId;
        public static PostResponse of(Post post){
            return PostResponse.builder()
                    .postId(post.getId())
                    .build();
        }
    }
}
