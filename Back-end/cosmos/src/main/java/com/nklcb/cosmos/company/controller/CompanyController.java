package com.nklcb.cosmos.company.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nklcb.cosmos.company.dto.CompanyDTO;
import com.nklcb.cosmos.company.service.CompanyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin_system/company")
public class CompanyController {

    private final CompanyService companyService;

    // 회사 정보 등록
    @PostMapping("/insert_company")
    public ResponseEntity<Void> insertCompany(@RequestBody CompanyDTO.CompanyInfo info) {
        companyService.insertCompany(info);
        return ResponseEntity.ok().build();
    }

}
