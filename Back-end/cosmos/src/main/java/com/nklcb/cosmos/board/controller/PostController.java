package com.nklcb.cosmos.board.controller;

import com.nklcb.cosmos.board.dto.PostDto;
import com.nklcb.cosmos.board.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
@Tag(name = "Post", description = "Post API")
public class PostController {
    private final PostService postService;

    @PostMapping
    @Operation(summary = "createPost", description = "새 게시글을 생성한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "성공",
                    content = {@Content(schema = @Schema(implementation = PostDto.PostResponse.class))}),
            @ApiResponse(responseCode = "404", description = "해당 ID의 유저가 존재하지 않습니다."),
    })
    public ResponseEntity<?> createPost(@Valid @RequestBody PostDto.PostCreateRequest postCreateRequest) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(postService.createPost(postCreateRequest));
        }catch (IllegalStateException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /*
    *  게시글 삭제
    *  게시글 조회 -> 페이지, 검색 기능 , 게시판 별
    * 게시글 조회 -> 페이지, 검색 기능 , 회원 별
    *  게시글 변경
    *
    *
    *
    *
    * */
}
