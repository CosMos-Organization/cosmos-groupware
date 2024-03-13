package com.nklcb.cosmos.email.repository;

import com.nklcb.cosmos.email.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email,Long> {

    String findByMemberId(String senderAddress);

}
