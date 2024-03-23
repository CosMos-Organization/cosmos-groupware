package com.nklcb.cosmos.commute.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nklcb.cosmos.commute.dto.CommuteDTO;
import com.nklcb.cosmos.commute.service.CommuteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/commute")
@RequiredArgsConstructor
@Tag(name = "Post", description = "Post API")
public class CommuteController {
    private final CommuteService commuteService;

    @PostMapping
    @Operation(summary = "createCommute", description = "출퇴근 기록")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "성공",
            content = {@Content(schema = @Schema(implementation = CommuteDTO.CommuteResponse.class))}),
        @ApiResponse(responseCode = "404", description = "찾을 수 없음"),
    })

    public ResponseEntity<?> creatPost(@Valid @RequestBody CommuteDTO.CommuteCreateRequest commuteCreateRequest) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(commuteService.createCommute(commuteCreateRequest));
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
