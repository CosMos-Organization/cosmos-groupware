package com.nklcb.cosmos.schedule.repository;

import com.nklcb.cosmos.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
