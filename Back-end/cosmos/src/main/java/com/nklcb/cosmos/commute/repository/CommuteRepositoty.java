package com.nklcb.cosmos.commute.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nklcb.cosmos.commute.entity.Commute;

public interface CommuteRepositoty extends JpaRepository<Commute, Long>{
}
