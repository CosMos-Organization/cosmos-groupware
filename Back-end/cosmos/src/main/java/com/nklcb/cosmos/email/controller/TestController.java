package com.nklcb.cosmos.email.controller;

import com.nklcb.cosmos.email.dto.EmailDto;
import com.nklcb.cosmos.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/email")
@RestController
public class TestController {


    private final EmailService emailService;



    @PostMapping("save")
    public ResponseEntity<String> writeEmail(@RequestBody EmailDto emailDto){
        emailService.writeEmail(emailDto);
        return ResponseEntity.ok().build();
    }




}
