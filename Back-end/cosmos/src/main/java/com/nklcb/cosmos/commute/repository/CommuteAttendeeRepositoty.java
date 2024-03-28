package com.nklcb.cosmos.commute.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nklcb.cosmos.commute.entity.CommuteAttendee;

public interface CommuteAttendeeRepositoty extends JpaRepository<CommuteAttendee, Long>{
    
}
