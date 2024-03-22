package com.nklcb.cosmos.organization.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nklcb.cosmos.organization.entity.Department;
import com.nklcb.cosmos.organization.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/insert")
    public String insertDepartment(@RequestBody HashMap<String, String> map) {
        System.out.println("진입" + map);

        departmentService.insertDepartment(map);

        return "heelo";
    }

    @GetMapping("/list")
    public List<Department> getDepartmentList() {
        return departmentService.getDepartmentList();
    }

}
