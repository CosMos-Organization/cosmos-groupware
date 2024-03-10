package com.nklcb.cosmos.email.service;

import com.nklcb.cosmos.email.dto.EmailDto;
import com.nklcb.cosmos.email.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import nonapi.io.github.classgraph.json.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailService {


    private final EmailRepository emailRepository;


    public String writeEmail(EmailDto emailDto) {


        emailRepository.save(emailDto);

        return null;

    }
}