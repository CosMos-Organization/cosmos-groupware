package com.nklcb.cosmos.email.controller;

import com.nklcb.cosmos.email.dto.EmailDto;
import com.nklcb.cosmos.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    EmailService emailService;

    @PostMapping
    public ResponseEntity<String> writeEmail(@RequestBody EmailDto emailDto){

        return ResponseEntity.ok(emailService.writeEmail(emailDto));
    }




}
