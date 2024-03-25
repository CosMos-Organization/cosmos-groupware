package com.nklcb.cosmos.email.repository;

import com.nklcb.cosmos.email.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmailRepository extends JpaRepository<Email,Long> {

    List<Email> findAllBySenderAddress(String senderAddress);
}
