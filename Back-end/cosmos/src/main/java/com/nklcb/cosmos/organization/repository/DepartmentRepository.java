package com.nklcb.cosmos.organization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nklcb.cosmos.organization.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
    
}
