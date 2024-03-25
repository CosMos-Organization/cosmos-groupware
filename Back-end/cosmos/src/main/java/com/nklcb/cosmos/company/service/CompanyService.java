package com.nklcb.cosmos.company.service;

import org.springframework.stereotype.Service;

import com.nklcb.cosmos.company.dto.CompanyDTO;
import com.nklcb.cosmos.company.entity.Company;
import com.nklcb.cosmos.company.repository.CompanyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public void insertCompany(CompanyDTO.CompanyInfo info) {
        Company company = Company.builder()
                .companyName(info.getCompanyName())
                .companyManagerEmail(info.getCompanyManagerEmail())
                .companyPassword(info.getCompanyPassword())
                .companyPhone(info.getCompanyPhone())
                .build();

        companyRepository.save(company);
    }

}
