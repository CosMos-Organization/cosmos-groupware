package com.nklcb.cosmos.organization.entity;

import com.nklcb.cosmos.global.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Department extends BaseEntity {
    @Column
    private int companyId;
    @Column
    private int parentId;
    @Column
    private String departmentName;

    @Builder
    public Department(int companyId, int parentId, String departmentName) {
        this.companyId = companyId;
        this.parentId = parentId;
        this.departmentName = departmentName;
    }
}
