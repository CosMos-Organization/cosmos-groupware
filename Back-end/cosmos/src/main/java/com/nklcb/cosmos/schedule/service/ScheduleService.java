package com.nklcb.cosmos.schedule.service;

import com.nklcb.cosmos.schedule.dto.ScheduleDTO;

public interface ScheduleService {
    public ScheduleDTO.ScheduleResponse createSchedule(ScheduleDTO.ScheduleCreateRequest scheduleCreateRequest);

    public void deleteSchedule(Long scheduleId);
}
