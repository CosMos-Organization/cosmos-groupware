package com.nklcb.cosmos.schedule.controller;

import com.nklcb.cosmos.schedule.dto.ScheduleDTO;
import com.nklcb.cosmos.schedule.service.ScheduleService;
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
@RequestMapping("/schedule")
@RequiredArgsConstructor
@Tag(name = "Post", description = "Post API")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping
    @Operation(summary = "createSchedule", description = "새 일정을 생성한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "성공",
                    content = {@Content(schema = @Schema(implementation = ScheduleDTO.ScheduleResponse.class))}),
            @ApiResponse(responseCode = "400", description = "잘못된 요청"),

    })
    public ResponseEntity<?> createSchedule(@Valid @RequestBody ScheduleDTO.ScheduleCreateRequest scheduleCreateRequest) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.createSchedule(scheduleCreateRequest));
        }catch (IllegalStateException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    @Operation(summary = "deleteSchedule", description = "기존 일정을 삭제한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공"),
            @ApiResponse(responseCode = "404", description = "일정을 찾을 수 없음"),
    })
    public ResponseEntity<?> deleteSchedule(@RequestParam Long scheduleId) {
        try {
            scheduleService.deleteSchedule(scheduleId);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
