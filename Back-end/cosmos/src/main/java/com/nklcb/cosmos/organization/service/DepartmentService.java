package com.nklcb.cosmos.organization.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nklcb.cosmos.organization.entity.Department;
import com.nklcb.cosmos.organization.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public void insertDepartment(HashMap<String, String> map) {
        int parentId = 1;
        String departmentName = map.get("childDepart");
        Department department = Department.builder()
                .companyId(34)
                .parentId(parentId)
                .departmentName(departmentName)
                .build();

        departmentRepository.save(department);

    }

    public List<Department> getDepartmentList() {
        return departmentRepository.findAll();
    }

}
