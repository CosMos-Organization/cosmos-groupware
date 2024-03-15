package com.nklcb.cosmos.schedule.repository;

import com.nklcb.cosmos.schedule.entity.Schedule;
import com.nklcb.cosmos.schedule.entity.ScheduleAttendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleAttendeeRepository extends JpaRepository<ScheduleAttendee, Long> {
}
