package com.nklcb.cosmos.company.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import com.nklcb.cosmos.global.BaseEntity;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Company extends BaseEntity {

    private String companyName;
    private String companyManagerEmail;
    private String companyPassword;
    private int employeeCount;
    private int companyPhone;
    @CreatedDate
    private LocalDateTime companyCreatedAt;
    private LocalDateTime companyDeletedAt;

    @Builder
    public Company(String companyName, String companyManagerEmail, String companyPassword, int employeeCount,
            int companyPhone) {
        this.companyName = companyName;
        this.companyManagerEmail = companyManagerEmail;
        this.companyPassword = companyPassword;
        this.employeeCount = employeeCount;
        this.companyPhone = companyPhone;
    }

}
