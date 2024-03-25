package com.nklcb.cosmos.email.controller;

import com.nklcb.cosmos.email.dto.EmailDto;
import com.nklcb.cosmos.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/email")
@RestController
public class TestController {


    private final EmailService emailService;



    @PostMapping("/save")
    public ResponseEntity<String> writeEmail(@RequestBody EmailDto emailDto){
        emailService.writeEmail(emailDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/readEmailList")
    public ResponseEntity<List> readEmailList(@RequestBody EmailDto emailDto){
        return ResponseEntity.ok(emailService.readEmailList(emailDto));
    }




}
