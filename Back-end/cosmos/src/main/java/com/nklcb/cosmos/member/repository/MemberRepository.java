package com.nklcb.cosmos.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nklcb.cosmos.member.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
