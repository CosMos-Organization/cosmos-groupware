package com.nklcb.cosmos.company.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nklcb.cosmos.company.dto.CompanyDTO;
import com.nklcb.cosmos.company.entity.Company;
import com.nklcb.cosmos.company.service.CompanyService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin_system/company")
public class CompanyController {

    private final CompanyService companyService;

    // 회사 정보 등록
    @PostMapping("/insert_company")
    @Operation(summary = "회사 정보 등록", description = "회사 정보를 등록합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "회사 정보 등록 성공"),
            @ApiResponse(responseCode = "400", description = "회사 정보 등록 실패")
    })
    public ResponseEntity<Void> insertCompany(@Valid @RequestBody CompanyDTO.CompanyInfo info) {
        companyService.insertCompany(info);
        return ResponseEntity.ok().build();
    }

    // 모든 회사 정보 조회
    @GetMapping("/get_company")
    @Operation(summary = "모든 회사 정보 조회", description = "모든 회사 정보를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "회사 정보 조회 성공"),
            @ApiResponse(responseCode = "400", description = "회사 정보 조회 실패")
    })
    public ResponseEntity<List<Company>> getCompany() {
        List<Company> company = companyService.getCompany();
        return ResponseEntity.ok().body(company);
    }

}
