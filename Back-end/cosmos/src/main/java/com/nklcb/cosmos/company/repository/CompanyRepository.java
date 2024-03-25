package com.nklcb.cosmos.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nklcb.cosmos.company.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{
    
}
