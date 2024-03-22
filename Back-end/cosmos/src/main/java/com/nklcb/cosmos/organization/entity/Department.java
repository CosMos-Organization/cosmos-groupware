package com.nklcb.cosmos.organization.entity;

import com.nklcb.cosmos.global.BaseEntity;

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
    private int departmentId;
    private int companyId;
    private String memberId;
    private int parentId;
    private String parentName;
    private String departmentName;

    @Builder
    public Department(int departmentId, int companyId, String memberId, int parentId, String parentName, String departmentName) {
        this.departmentId = departmentId;
        this.companyId = companyId;
        this.memberId = memberId;
        this.parentId = parentId;
        this.parentName = parentName;
        this.departmentName = departmentName;
    }

}
